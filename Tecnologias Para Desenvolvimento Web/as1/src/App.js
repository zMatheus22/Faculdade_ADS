/*
  Tecnologias Para Desenvolvimento Web
  ATIVIDADE SOMATIVA 1 - Semana 4
  
  @Curso: Análise e Desenvolvimento de Sistemas
  @Autor: Matheus Vinicyus Strada
*/

import { Component } from "react";
import "./App.css";

class App extends Component {
  // Definir o estado inicial do componente (Construtor)
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      senha: "",
      mensagem: "",
    };
  }

  // Coletar o email do input e armazenar no estado do componente
  email(event) {
    const state = this.state;
    state.email = event.target.value;
  }

  // Coletar a senha do input e armazenar no estado do componente
  senha(event) {
    const state = this.state;
    state.senha = event.target.value;
  }

  // Função para validar o login do usuário, comparando com os dados pré-definidos
  validarLogin(email, senha) {
    const state = this.state;

    // Login valido para o acesso!
    const login = [
      {
        email: "matheus@email.com",
        senha: "matheus123",
      },
      {
        email: "eduardo.lino@pucpr.br",
        senha: "123456",
      },
    ];

    // Verificar se o email e senha do usuário correspondem a algum dos logins pré-definidos
    for (let i = 0; i < login.length; i++) {
      if (email === login[i].email && senha === login[i].senha) {
        state.mensagem = "Acessodo com sucesso!";
        this.setState(state);
        return;
      }
    }
    // Mensagem de erro para o usuário, caso o login seja inválido
    state.mensagem = "Usuário ou senha incorretos!";
    this.setState(state);
  }

  render() {
    return (
      <div className="App">
        <h1>Login</h1>
        <input
          type="text"
          placeholder="user@email.com"
          size="20"
          nome="email"
          onChange={(e) => this.email(e)}
        />
        <br />
        <input
          type="password"
          placeholder="senha"
          size="20"
          nome="senha"
          onChange={(e) => this.senha(e)}
        />
        <br />
        <button
          onClick={() => this.validarLogin(this.state.email, this.state.senha)}
        >
          Entrar
        </button>
        <br />
        <br />
        <label>{this.state.mensagem}</label>
      </div>
    );
  }
}

export default App;
