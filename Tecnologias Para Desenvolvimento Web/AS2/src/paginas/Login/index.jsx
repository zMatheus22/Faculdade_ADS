import { auth } from '../../firebaseConnection';
import { signInWithEmailAndPassword } from 'firebase/auth';
import { Link } from 'react-router-dom';
import { Component } from 'react';
import "../../index.css";

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      senha: '',
    };
    this.login = this.login.bind(this);
  }

  async login() {
    await signInWithEmailAndPassword(auth, this.state.email, this.state.senha)
      .then(() => {
        window.location.href = "/";
      })
      .catch(() => {
        alert("Usuário não está cadastrado ou credenciais inválidas.");
      });
  }

  render(){
    return (
    <div>
      <h1>Login</h1>
      <input type="email" placeholder="email@email.com" value={this.state.email} onChange={(e) => this.setState({email: e.target.value})} required /><br/>
      <input type="password" placeholder="******" value={this.state.senha} onChange={(e) => this.setState({senha: e.target.value})} required /><br/>
      <button onClick={this.login}>Acessar</button>
      <Link to="/cadastro">Cadastre-se</Link>
    </div>
    );
  }
}

export default Login;
