<%@ page import="controle.Fabricante" %>



<div class="fieldcontain ${hasErrors(bean: fabricanteInstance, field: 'cnpj', 'error')} required">
	<label for="cnpj">
		<g:message code="fabricante.cnpj.label" default="Cnpj" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cnpj" required="" value="${fabricanteInstance?.cnpj}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: fabricanteInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="fabricante.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${fabricanteInstance?.nome}"/>

</div>

