<%@ page import="controle.Produto" %>



<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="produto.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" required="" value="${produtoInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'fabricante', 'error')} required">
	<label for="fabricante">
		<g:message code="produto.fabricante.label" default="Fabricante" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fabricante" name="fabricante.id" from="${controle.Fabricante.list()}" optionKey="id" required="" value="${produtoInstance?.fabricante?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="produto.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${produtoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'preco', 'error')} required">
	<label for="preco">
		<g:message code="produto.preco.label" default="Preco" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preco" value="${fieldValue(bean: produtoInstance, field: 'preco')}" required=""/>

</div>

