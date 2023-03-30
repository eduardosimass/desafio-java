<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Gerenciador de Projetos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/cadastro">Novo Cadastro <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item inactive">
        <a class="nav-link " href="/projetos">Meus Projetos</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</div>
    <div class="container mt-4">
        <h1 class="text-center mb-4">Sistema de Gerenciamento de Projetos</h1>
        <table aria-describedby="mydesc" class="table table-striped">
            <thead class="thead-light">
                <tr>
                    <th>ID</th>
                    <th>Nome do Projeto</th>
                    <th>Data de Início</th>
                    <th>Gerente Responsável</th>
                    <th>Previsão de Término</th>
                    <th>Data Real de Término</th>
                    <th>Orçamento Total</th>
                    <th>Descrição</th>
                    <th>Status</th>
                    <th>Risco</th>
                    <th>Ações</th>
                </tr>
            </thead>
             <tbody>
                           <c:forEach var="projetos" items="${projetos}">
                               <tr>
           						<tr>
           						<input id="idItem" type="hidden" name="nomeDoCampo" value="${projetos.id}">
           							<td  value='${projetos.id}'>${projetos.id}</td>
           							<td>${projetos.nome}</td>
           							<td>${projetos.dataInicio}</td>
           							<td>${projetos.nome}</td>
           							<td>${projetos.dataPrevisaoFim}</td>
           							<td>${projetos.dataFim}</td>
           							<td>${projetos.orcamento}</td>
           							<td>${projetos.descricao}</td>
           							<td>${projetos.status}</td>
           							<td>${projetos.risco}</td>
                                   <td>
                                    <button type="button"  data-id="${projetos.id}" id="idItem"  onclick="RecuperaId(); BuscaPessoa(); RecuperarDados(this)"    class="btn btn-dark mb-4" data-toggle="modal" data-target="#modalEditarProjeto"><i data-id='${projetos.id}' class="bi bi-pencil"></i></button>
                                    <button type="button"  data-id="${projetos.id}" id="delete" class="btn btn-danger" onclick="RecuperaId(); deleteProjeto(idItemRow)" ><i data-id='${projetos.id}'class="bi bi-trash"></i></button>
                                  </td>
                                  </form>
                                    </c:forEach>
                               </tr>
       </tbody>
    <!--Modal-->

  <!-- Modal Editar Projeto-->
  <div class="modal fade" id="modalEditarProjeto" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
	  <div class="modal-content">
		<div class="modal-header">
		  <h5 class="modal-title" id="exampleModalLongTitle">Editar Cadastro</h5>
		  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="modal-body">
				<div class="form-row">
				  <div class="form-group col-md-6">
					<label for="nome">Nome do Projeto:</label>
			  <input  value='' type="text" class="form-control" id="nome" name="nome" >
				  </div>
                  <div class="form-group col-md-6">
                    <label for="gerenteResponsavel">Gerente Responsável:</label>

                                          <select class="form-control" id="gerente" name="gerente">


                                          </select>

                  </div>
				 <div class="form-group col-md-6">
					<label for="inputDataInicio">Data de Inicio:</label>
					<input value='' type="date" class="form-control" id="dataInicio" name="dataInicio" >
				  </div>
                    <div class="form-group col-md-6">
                      <label for="data_previsao_fim">Previsão de Termino:</label>
                      <input value='' type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" >
                    </div>
                    <div class="form-group col-md-4">
                                          <label for="data_fim"> Data Real Termino:</label>
                                          <input value='' type="date" class="form-control" id="dataFim" name="dataFim" >
                                        </div>
                  <div class="form-group col-md-12">
                    <label for="descricao">Descrição:</label>
                    <textarea  value=''class="form-control" id="descricao" name="descricao" ></textarea>
                  </div>

                  <div class="form-group col-md-4">
                    <label for="orcamentoTotal">Orçamento Total:</label>
                    <input value='' type="number" placeholder="R$" class="form-control" id="orcamento" name="orcamento" >
                  </div>
                  <div class="form-group col-md-4">
                      <label for="risco">Risco:</label>
                      <select class="form-control" id="risco" name="risco">
                        <option value=''>Baixo Risco</option>
                        <option value=''>Médio Risco</option>
                        <option value=''>Alto Risco</option>
                      </select>
                    </div>
                      <div class="form-group col-md-4">
                                          <label for="status">Status:</label>
                                          <select class="form-control"  id="status" name="status">
                                            <option>em analise</option>
                                            <option>analise realizada</option>
                                            <option>analise aprovada</option>
                                             <option>iniciado</option>
                                              <option>planejado</option>
                                                <option>em andamento</option>
                                                <option>encerrado</option>
                                                 <option>cancelado</option>


                                          </select>
                                        </div>
      		</div>
		<div class="modal-footer">
		 <c:forEach var="projetos" items="${projetos}" >
		 </c:forEach>
		 <button  type="button" id="idItem" data-id="idItem" onclick="AlterarDados();" data-dismiss="modal"   class="btn btn-primary">Salvar</button>

		  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		 </div>
	  </div>
	</div>
  </div>



	<script src="/static/js/index.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<div>
<button type="button" class="btn btn-light">Light</button>
</div>
</div>
</body>

</html>
