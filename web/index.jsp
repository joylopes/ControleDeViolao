
<%@page import="model.bean.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.AlunoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style.css" />
        <title>Controle do Violão</title>
    </head>
    <body>
        <div id="topo"></div>

        <div id="fundoLb"></div>

        <div id="lbExcluir" class="lbPergunta">
            <div class="fecharLb fecharTudo">X</div>
            <h2>Deseja Excluir este Aluno ?</h2>
            <button class="btn btn-success " id="excluirAlunoLb" >Sim</button>
            <button class="btn btn-danger fecharTudo">Não</button>
        </div>
        <div id="lbViolao" class="lbPergunta">
            <div class="fecharLb fecharTudo">X</div>
            <h2>Deseja mudar o status do aluno referente a  entrega do violao ?</h2>
            <button class="btn btn-success " id="mudarStatusViolaoLb">Sim</button>
            <button class="btn btn-danger fecharTudo">Não</button>
        </div>
        <div class="clearfix"></div>
        <div class="container fundo">

            <div class="col-md-12">
                <h2>Cadastrar Alunos:</h2>
                <div class="col-md-6">   
                    <label>Digite o Nome:</label>
                    <input type="text" class="form-control" name="nome" id="nomeProd" value="">
                </div>
                <div class="col-md-6">            
                    <label>O Aluno levou um violão ?</label>
                    <select type="text" class="form-control" name="violao" id="violaoProd" >
                        <option value="Sim" >Sim</option>
                        <option value="Nao" >Não</option>
                    </select>
                </div>
                <div class="col-md-12">            
                    <label>Digite uma observação:</label>
                    <textarea type="text" class="form-control" name="obs" id="obsProd" ></textarea>
                </div>
                <div class="col-md-8">
                    <p>Clique em Cadastrar para cadastrar um novo usuario.</p>
                </div>
                <div class="col-md-4">
                    <br>
                    <input type="submit"  class="btn btn-primary btn-block" id="enviarProduto" name="btenviiar" value="Cadastrar">    
                </div>


            </div>    

            <div class="col-md-12">
                <h2>Lista de Alunos:</h2>
                            <p>As celulas das colunas Nome,Obs e Aluno Com o Violão? são editáveis. Clique em cima e edite !</p>


                <div class="col-md-12 ">

                    <div class="col-md-9" style="padding: 0">
                        <label>Pesquisar aqui:</label>
                        <input type="text" id="pesquisaCriterio" placeholder="Pesquise Aqui" class="form-control">
                    </div>
                    <div class="col-md-3" style="padding: 0">
                        <label>Pesquisar por:</label>
                        <select id="criterio" class="form-control">
                            <option value="nome">Nome</option>
                            <option value="codigo">Código</option>
                        </select>
                    </div>
                    <p id="avisoRolarTabela">Role a tabela para o lado para ver tudo !</p>
                    <div class="flow">
                        <table class="table table-striped table-bordered table-responsive" id="tabela">
                            <thead>
                                <tr>   
                                    <th>Código</th>
                                    <th>Nome</th>
                                    <th>Obs</th>
                                    <th>Aluno Com o Violão ?</th>
                                    <th></th>
                                </tr>
                            </thead> 
                            <tbody id="listarProdutos">   

                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-4">
                </div> 
                <div class="col-md-4">
                    <img src="images/gif.gif" alt="" id="gif" style="display: none; width: 100%">
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
        <script type="text/javascript" src="js/app.js"></script>
    </body>
</html>
