

$(function () {
    //listar
    var listarProdutos = function () {
        $("#gif").show();
        $.ajax({
            type: "POST",
            url: "ListarProdutos",
            success: function (r) {
                $("#listarProdutos").html(r);
                $("#gif").hide();
            }
        });
    };
//deletar
    var deletarProdutos = function (id) {
        $.ajax({
            type: "POST",
            url: "Excluir",
            data: {
                excluirProdutoId: id
            },
            success: function (r) {
                listarProdutos();
            }
        });

    };

    var idAlunoE = 0;
    $(document).on('click', '.excluirAluno', function () {
        idAlunoE = $(this).attr("name");
        $("#fundoLb").show();
        $("#lbExcluir").show();
        window.location.href = "#topo";
    });
    $(document).on('click', '#excluirAlunoLb', function () {
        deletarProdutos(idAlunoE);
        $("#fundoLb").hide();
        $("#lbExcluir").hide();
    });




//fechar lb 
    $(document).on('click', '.fecharTudo', function () {
        $("#fundoLb").hide();
        $(".lbPergunta").hide();
    });
    // editar
    var editarProdutos = function (id, coluna, texto, recarregar) {

        $.ajax({
            type: "POST",
            url: "Editar",
            data: {
                id: id,
                coluna: coluna,
                texto: texto
            },
            success: function (r) {
//                   $('body').html(r);
                if (recarregar) {
                    listarProdutos();
                }
            }
        });

    };



    $(document).on('keyup', '.editavel', function () {

        var name = $(this).attr("name");
        var texto = $(this).text();

        name = name.split("/");
        var coluna = name[0];
        var id = name[1];
        editarProdutos(id, coluna, texto);

    });



    //mudar status do violao do aluno
    var nameViolao = "";
    var textoViolao = "";
    $(document).on('click', '.btnViolao', function () {
        nameViolao = $(this).attr("name");
        textoViolao = $(this).text();
        $("#fundoLb").show();
        $("#lbViolao").show();
        window.location.href = "#topo";

    });

    $(document).on('click', '#mudarStatusViolaoLb', function () {

        var name = nameViolao.split("/");
        var coluna = name[0];
        var id = name[1];
        if (textoViolao === "Sim") {
            editarProdutos(id, coluna, "Nao", "Sim");
        } else {
            editarProdutos(id, coluna, "Sim", "Sim");
        }
        $("#fundoLb").hide();
        $("#lbViolao").hide();
    });

//salvar
    var salvarProdutos = function () {
        $.ajax({
            type: "POST",
            url: "Enviar",
            data: {
                nome: $("#nomeProd").val(),
                obs: $("#obsProd").val(),
                violao: $("#violaoProd").val()
            },
            success: function (r) {
                console.log(r);
                listarProdutos();
            }
        });

    };

    $(document).on('click', '#enviarProduto', function () {
        salvarProdutos();
    });


//Filtro 
var filtroDePesquisa = function(pesquisa ,criterio){
  $("."+criterio+"Td").each(function(i){
     var celula = $(this).text();
     celula = celula.toLowerCase();
     pesquisa = pesquisa.toLowerCase();
     if(!celula.match(pesquisa)){
         $(this).parent().hide();
     }
     else{
         $(this).parent().show();
     }
  });
};
$(document).on('keyup', '#pesquisaCriterio', function () {
filtroDePesquisa($(this).val(),$("#criterio").val());
});
$(document).on('change', '#criterio', function () {  
    var criterio = $(this).val();   
    if(criterio == "codigo"){
            $("#pesquisaCriterio").attr("type","number");
    }else{
            $("#pesquisaCriterio").attr("type","text");
    }
    $("#pesquisaCriterio").val("");
    filtroDePesquisa("","nome");
});


    listarProdutos();
});

