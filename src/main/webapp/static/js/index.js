function Reload(){
document.location.reload(true);
}

var idItemRow = null;
var idGerente = null
 function RecuperaId(e) {
  idItemRow = event.target.dataset.id;
  console.log(idItemRow)
  console.log(event.target)

}


function RecuperarDados(button) {
  const itemId = button.dataset.id;
  const url = `http://127.0.0.1:8080/projeto/${itemId}`;
  fetch (url)
    .then(response => response.json())
    .then(data => {
      document.getElementById('nome').value = data.nome;
      /*document.getElementById('gerente').value = data.membros[0].nome;*/
      document.getElementById('dataInicio').value = data.dataInicio;
      document.getElementById('dataPrevisaoFim').value = data.dataPrevisaoFim;
      document.getElementById('dataFim').value = data.dataFim;
      document.getElementById('orcamento').value = data.orcamento;
      document.getElementById('descricao').value = data.descricao;
      document.getElementById('status').value = data.status;
      document.getElementById('risco').value = data.risco;
    })
    .catch(error => {
      console.error('Erro:', error);
    });

}

function BuscaPessoa() {
      const urlPessoa = `http://127.0.0.1:8080/pessoa`;

      fetch(urlPessoa)
        .then(response => response.json())
        .then(data => {
          const gerenteSelect = document.getElementById('gerente');
          let html = '';
          data.forEach(pessoa => {
            html += `
            <option  value="${pessoa.id}" id=idI>${pessoa.nome}</option>`;

          });
          gerenteSelect.innerHTML = html;
        })
        .catch(error => {
          console.error('Erro:', error);
        });
    }

function AlterarDados() {
      const urlEditar = `http://127.0.0.1:8080/projeto/editar/${idItemRow}`;
      const inputData = {
        nome: document.getElementById('nome').value,
        dataInicio: document.getElementById('dataInicio').value,
        gerente: document.getElementById('gerente').value,
        dataPrevisaoFim: document.getElementById('dataPrevisaoFim').value,
        dataFim:  document.getElementById('dataFim').value,
        orcamento: document.getElementById('orcamento').value,
        descricao: document.getElementById('descricao').value,
        status: document.getElementById('status').value,
        risco: document.getElementById('risco').value
      };

      fetch(urlEditar, {
            method: 'PUT',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(inputData)

          })
          .then(response => {
            if (response.ok) {
              location.reload();
            }
            return response.json()
          })
          .then(data => console.log(data))
          .catch(error => console.error(error))


      }


      function Cadastro() {
            const urlCadastro = `http://127.0.0.1:8080/projeto/`;
            const inputData = {
              nome: document.getElementById('nome').value,
              dataInicio: document.getElementById('dataInicio').value,
              dataPrevisaoFim: document.getElementById('dataPrevisaoFim').value,
              dataFim:  document.getElementById('dataFim').value,
              orcamento: document.getElementById('orcamento').value,
              descricao: document.getElementById('descricao').value,
              status: document.getElementById('status').value,
              risco: document.getElementById('risco').value
            };

            fetch(urlCadastro, {
                  method: 'POST',
                  headers: {
                    'Content-Type': 'application/json'
                  },
                  body: JSON.stringify(inputData)

                })
                .then(response => {
                  if (response.ok) {
                    location.reload();
                  }
                  return response.json()
                })
                .then(data => console.log(data))
                .catch(error => console.error(error))


            }


function deleteProjeto() {
const urldeletar = `http://127.0.0.1:8080/projeto/delete/${idItemRow}`;
  fetch( urldeletar, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(response => {
      if (!response.ok) {
      alert('Projeto Já iniciado, em Andamento ou Encerrado! Verifique!')
      }else if (response.ok){
      alert('Projeto removido com sucesso!')
      }  location.reload();
      return response.json(   )
    })
    .then(data => console.log(data))
    .catch(error => console.error(error))

  }

function GerenteResponsavel(e){
       const gerente = document.getElementById('gerente').value;
       const urlGerente = `http://127.0.0.1:8080/associacoes`;
       fetch(urlGerente, {
             method: 'POST',
             headers: {
               'Content-Type': 'application/json'
             },
             body: JSON.stringify()

           })
           .then(response => {
             if (response.ok) {
               location.reload();
             }

           })


}


