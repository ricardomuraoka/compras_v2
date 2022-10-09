## Desenvolvido através do Programa de Atração e Desenvolvimento de Talentos PUCPR- Visionnaire - Bradesco

## Vamos desenvolver um pequeno sistema de loja. O tema da loja é livre (supermercado, loja de roupas, de games, etc).


# [Vídeo do Projeto](https://youtu.be/w4pcy3YI3Kg)

# Módulos
## Login
### Na entrada, o sistema pergunta o cpf e a senha do usuário. O sistema possui um usuário administrador (login: admin e senha: admin).

### Caso o usuário não seja cadastrado, exibir a mensagem: "Usuário não cadastrado". Em seguida, dar a opção de cadastrar um novo usuário.
### Caso o usuário exista, vá para o menu principal.

## Menu principal

### O menu principal deve apresentar as seguintes opções (não necessariamente com esses textos ou nessa ordem):

### Fazer compras: Desvia o sistema para o módulo de compras
### (admin) Relatório sobre clientes
### Trocar usuário
### Sobre: Lista dados como nome e versão do sistema e nome do seu criador.
### Sair

# Módulo de compras
# Deve fornecer as seguintes opções:

### Buscar produto: Localiza na loja todos os produtos que tenham um determinado nome
### Listar todos os produtos.
### Adicionar o produto ao carrinho: Adiciona o produto ao carrinho. O cliente deve ser questionado sobre quantas unidades devem ser adicionadas. Ele não poderá adicionar mais produtos do que há no estoque.
### Exibir carrinho: Exibe os produtos no carrinho, mostrando inclusive o total da compra. Também dá as opções de retornar as compras ou de finalizar a compra. Se a compra for finalizada, será salva no histórico do cliente.
### Voltar ao menu principal

# Relatório de clientes
### Exibe uma listagem de clientes, o número de compras, o total comprado e o valor médio de compra.
### Ao final, exibe também o total geral vendido.

# Orientações gerais

### Procure usar as práticas vistas em aula
### Evite ao máximo realizar impressão de texto (printf) em classes de negócios. Tente separa-las das classes de interface gráfica. Nas classes de negócios lembre-se do String.format e do método toString()
### Todas as listagens devem ser paginadas. Dê a opção de avançar / voltar cada página. Escolha um tamanho de página que torne o sistema agradável de usar
### Não há um cadastro de estoque. Você pode cadastra-lo diretamente no código.
### O trabalho é individual e será apresentado no dia 09/09.
### Essa atividade não depende de conteúdos da próxima aula
### O tempo final da próxima aula também poderá ser usado para fazer este trabalho, haverá exibição de conteúdo
### Trata-se de um trabalho, não de uma prova. Você está livre para conversar com seus colegas, pedir ajuda ou ajuda-los.
## Requisitos opcionais
### Caso sobre tempo, tente realizar um ou mais desses requisitos:

### Valide o CPF digitado
### Ordene o relatório de clientes do que mais comprou para o que menos comprou. A ordenação pode ser feita pela média ou pelo valor total da compra.
### Adicione um módulo para gerenciar os produtos do estoque
### Carregue uma listagem de produtos pré-cadastrada de um arquivo de textos
### Salve os dados em arquivos de texto, de modo que o sistema não perca nada quando for fechado
### Você trabalhou utilizando o github (fez commits com mensagens, criou uma versão do repositório na data de entrega e enviou a url do repositório no canvas).

#Agora que você já aprendeu bastante sobre o Java, que tal criar a versão 2.0 do seu aplicativo de compras?

#Orientações gerais

###Utilize streams para as listas
###Certifique-se de utilizar a orientação à objetos (evite dezenas de métodos estáticos)
###Tente repensar se o uso de interfaces faz sentido em algum lugar
###Utilize o mecanismo de tratamento de erros corretamente
###Implemente pelo menos 1 dos extras descritos no trabalho original