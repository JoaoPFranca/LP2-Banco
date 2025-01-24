<h2 id="sobre">💻 O que é?</h2>
Implementação de um sistema com o objetivo de simular um banco, explorando os conceitos abordados na disciplina de Linguagem de Programação 2 do curso de BTI - UFRN.

<h2 id="equipe">💻 Feito por:</h2>
João Pedro de França Barboza

<h2 id="novidades">➕ Features Banco 2:</h2>

### 🏦 Suporte a Múltiplas Agências
Agora, um banco pode gerenciar várias agências.  
**Implementação:** model/Agencia.java

### 🧾 Novos Tipos de Conta
Adicionados três tipos de contas utilizando herança. Cada tipo possui características específicas:  
- **ContaCorrente**: Cada depósito tem um desconto de 5%.  
- **ContaPoupanca**: Cada depósito recebe um bônus de 5%.  
- **ContaSalario**:  
  - Possui um limite de 5 saques.  
  - Somente pode receber transferências da conta do empregador.

### ⚠️ Tratamento de Exceções
Implementado o tratamento de exceções personalizadas para operações bancárias.  
**Implementação:** exception/BancoException.java

### 📄 Exportação de Dados
Os dados do banco agora podem ser exportados no formato CSV.  
**Implementação:** controller/BancoController.java

### 📄 Importação de Dados
Os dados do banco agora podem ser importados a partir do arquivo banco.csv.  
**Implementação:** controller/BancoController.java
  

<h2 id="observacoes">💻 Observações:</h2>
Decidi implementar do zero com o intuito de colocar em prática todos os conhecimentos adquiridos em Java.
