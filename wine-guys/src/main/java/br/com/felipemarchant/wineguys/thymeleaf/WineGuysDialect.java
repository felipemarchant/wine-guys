package br.com.felipemarchant.wineguys.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import br.com.felipemarchant.wineguys.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.com.felipemarchant.wineguys.thymeleaf.processor.MenuAttributeTagProcessor;
import br.com.felipemarchant.wineguys.thymeleaf.processor.PaginationElementTagProcessor;
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.felipemarchant.wineguys.thymeleaf.processor.MessageElementTagProcessor;
import br.com.felipemarchant.wineguys.thymeleaf.processor.OrderElementTagProcessor;

@Component
public class WineGuysDialect extends AbstractProcessorDialect {

	public WineGuysDialect() {
		super("WineGuys", "wineguys", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		processadores.add(new PaginationElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}

}
