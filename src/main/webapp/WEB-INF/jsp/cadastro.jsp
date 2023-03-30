<%@page contentType="text/html" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Cadastro de Projetos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">  </head>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item inactive">
          <a class="nav-link " href="/cadastro">Novo Projeto <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item active">
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
  <body>
    <div class="container mb-3">
      <h1>Cadastro de Projeto</h1>
      <form>
        <div class="form-group mb-4">
          <label for="nome">Nome</label>
          <input type="text" class="form-control" id="nome" required>
        </div>
        <div class="form-group">
          <label for="dataInicio">Data de Início</label>
          <input type="date" class="form-control" id="dataInicio" name="dataInicio" required>
        </div>

        <div class="form-group">
          <label for="previsaoTermino">Previsão de Término</label>
          <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" required>
        </div>
        <div class="form-group">
          <label for="previsaoTermino">Data Final</label>
          <input type="date" class="form-control" id="dataFim" name="dataFim" required>
        </div>
        <div class="form-group">
          <label for="orcamentoTotal">Orçamento Total R$:</label>
         <input type="text" step="0.01" class="form-control" id="orcamento" name="orcamento" required>
        </div>
        <div class="form-group">
          <label for="descricao">Descrição</label>
          <textarea class="form-control" id="descricao" name="descricao" rows="3" required></textarea>
        </div>
        <div class="form-group">
          <label for="status">Status</label>
          <select class="form-control" id="status" name="status" required>
            <option selected>Selecione uma Opção</option>
            <option>em analise</
            option>
            <option>analise realizada</option>
            <option>analise aprovada</option>
            <option>iniciado</option>
            <option>planejado</option>
            <option>em andamento</option>
            <option>encerrado</option>
            <option>cancelado</option>
          </select>
        </div>
        <div class="form-group">
          <label for="risco">Risco</label>
          <select class="form-control" id="risco" name="risco" required>
            <option selected>Selecione uma Opção</option>
            <option>Baixo Risco</option>
            <option>Médio Risco</option>
            <option>Alto Risco</option>
          </select>
        </div>
        <button type="button" class="btn btn-primary" onclick="Cadastro()">Cadastrar</button>
      </form>
    </div>
    <script src="/static/js/index.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>