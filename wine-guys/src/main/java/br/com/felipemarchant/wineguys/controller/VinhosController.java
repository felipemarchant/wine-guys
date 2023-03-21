package br.com.felipemarchant.wineguys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import br.com.felipemarchant.wineguys.controller.page.PageWrapper;
import br.com.felipemarchant.wineguys.model.Vinho;
import br.com.felipemarchant.wineguys.repository.Vinhos;
import br.com.felipemarchant.wineguys.repository.Estilos;
import br.com.felipemarchant.wineguys.repository.filter.VinhoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.felipemarchant.wineguys.dto.VinhoDTO;
import br.com.felipemarchant.wineguys.model.Origem;
import br.com.felipemarchant.wineguys.model.Sabor;
import br.com.felipemarchant.wineguys.service.CadastroVinhoService;
import br.com.felipemarchant.wineguys.service.exception.ImpossivelExcluirEntidadeException;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroVinhoService cadastroVinhoService;
	
	@Autowired
	private Vinhos vinhos;

	@RequestMapping("/nova")
	public ModelAndView nova(Vinho vinho) {
		ModelAndView mv = new ModelAndView("vinho/CadastroVinho");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@RequestMapping(value = { "/nova", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return nova(vinho);
		}
		
		cadastroVinhoService.salvar(vinho);
		attributes.addFlashAttribute("mensagem", "Vinho salva com sucesso!");
		return new ModelAndView("redirect:/vinhos/nova");
	}
	
	@GetMapping
	public ModelAndView pesquisar(VinhoFilter vinhoFilter, BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("vinho/PesquisaVinhos");
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		
		PageWrapper<Vinho> paginaWrapper = new PageWrapper<>(vinhos.filtrar(vinhoFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VinhoDTO> pesquisar(String skuOuNome) {
		return vinhos.porSkuOuNome(skuOuNome);
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Vinho vinho) {
		try {
			cadastroVinhoService.excluir(vinho);
		} catch (ImpossivelExcluirEntidadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Vinho vinho) {
		ModelAndView mv = nova(vinho);
		mv.addObject(vinho);
		return mv;
	}
	
}
