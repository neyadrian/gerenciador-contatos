# 📇 Gerenciador de Contatos Profissionais

## 📖 Descrição

Sistema de gerenciamento de contatos profissionais desenvolvido em Java, com persistência em arquivo utilizando a API moderna `java.nio.file`. O projeto implementa conceitos fundamentais de Programação Orientada a Objetos como herança, polimorfismo, encapsulamento e interfaces.

## ✨ Funcionalidades

- ✅ Adicionar clientes com empresa
- ✅ Adicionar fornecedores com serviço
- ✅ Listar todos os contatos
- ✅ Buscar contatos por nome
- ✅ Atualizar informações de contatos
- ✅ Remover contatos
- ✅ Persistência em arquivo (contatos.txt)
- ✅ Validação de duplicidade de email
- ✅ Menu interativo intuitivo

## 🏗️ Arquitetura OOP

### Classes Principais

| Classe | Descrição |
|--------|-----------|
| **Contato** | Classe abstrata base com atributos nome e email |
| **Cliente** | Herda de Contato, adiciona atributo empresa |
| **Fornecedor** | Herda de Contato, adiciona atributo servico |
| **Persistencia** | Interface para persistência de dados |
| **AgendaArquivo** | Implementa Persistencia usando NIO |
| **Agenda** | Gerenciador CRUD completo |
| **Main** | Classe principal com menu interativo |

### Enum

- **TipoContato**: CLIENTE, FORNECEDOR

## 📁 Estrutura do Projeto

```
gerenciador-contatos/
├── src/
│   ├── aplicacao/
│   │   └── Main.java
│   └── modelo/
│       ├── Agenda.java
│       ├── AgendaArquivo.java
│       ├── Cliente.java
│       ├── Contato.java
│       ├── Fornecedor.java
│       ├── Persistencia.java
│       └── TipoContato.java
├── contatos.txt
└── README.md
```

## 🚀 Como Usar

### Compilação

```bash
javac -d bin src/**/*.java
```

### Execução

```bash
java -cp bin aplicacao.Main
```

## 📋 Menu Principal

```
╔════════════════════════════════════════╗
║     GERENCIADOR DE CONTATOS           ║
╚════════════════════════════════════════╝

1 - Adicionar Cliente
2 - Adicionar Fornecedor
3 - Listar Contatos
4 - Buscar por Nome
5 - Atualizar Contato
6 - Remover Contato
0 - Sair

Digite sua opção:
```

## 💾 Formato de Persistência

Os contatos são salvos em `contatos.txt` no formato:

```
TIPO;nome;email;extra
```

### Exemplos

```
CLIENTE;João Silva;joao@email.com;Google
FORNECEDOR;Maria Santos;maria@email.com;Serviços de Internet
CLIENTE;Pedro Costa;pedro@email.com;Microsoft
```

## ✔️ Validações Implementadas

- ✅ Impede email duplicado
- ✅ Valida campos obrigatórios
- ✅ Não permite nomes vazios
- ✅ Não permite emails inválidos
- ✅ Carregamento automático ao iniciar
- ✅ Salvamento automático ao modificar

## 📋 Requisitos Atendidos

- ✅ Classe Abstrata (Contato)
- ✅ Herança (Cliente e Fornecedor)
- ✅ Enum (TipoContato)
- ✅ Interface (Persistencia)
- ✅ Implementação com NIO (AgendaArquivo)
- ✅ Collections (ArrayList)
- ✅ CRUD Completo
- ✅ Polimorfismo
- ✅ Encapsulamento
- ✅ Menu Interativo

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 8+
- **API de Arquivo**: java.nio.file (Files, Paths)
- **Collections**: ArrayList
- **Paradigma**: Programação Orientada a Objetos

## 👤 Autor

**Ney Adrian**

---

*Projeto desenvolvido para fins educacionais com foco em conceitos fundamentais de POO.*
