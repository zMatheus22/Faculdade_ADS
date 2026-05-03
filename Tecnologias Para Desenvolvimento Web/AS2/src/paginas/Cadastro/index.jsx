import { Component } from 'react';
import { auth, db } from '../../firebaseConnection';
import { createUserWithEmailAndPassword } from 'firebase/auth';
import { doc, setDoc } from 'firebase/firestore';
import "../../index.css";

class Cadastro extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      nome: '',
      sobrenome: '',
      dataNascimento: '',
      email: '',
      senha: '',
    };
    this.gravar = this.gravar.bind(this);
  }

  validarFormulario() {
    if (this.state.nome === '') {
      alert("Nome inválido!");
      return false;
    }
    if (this.state.sobrenome === '') {
      alert("Sobrenome inválido!");
      return false;
    }
    if (this.state.dataNascimento === '') {
      alert("Data de nascimento inválida!");
      return false;
    }
    if (this.state.email === '') {
      alert("Email inválido!");
      return false;
    }
    if (this.state.senha === '') {
      alert("Senha inválida!");
      return false;
    }
    return true;
  }

  async gravar() {
    // Validação do formulário
    if (!this.validarFormulario()) {
      return;
    }
    // 1. Primeiro criamos o usuário no Authentication
    await createUserWithEmailAndPassword(auth, this.state.email, this.state.senha)
      .then(async (userCredential) => {
        const uid = userCredential.user.uid;

        // 2. Agora gravamos no Firestore usando o UID como ID do documento
        // doc(banco, nome_colecao, id_do_documento)
        await setDoc(doc(db, "usuario", uid), {
          nome: this.state.nome,
          sobrenome: this.state.sobrenome,
          dataNascimento: this.state.dataNascimento,
          email: this.state.email,
          uid: uid
        })
        .then(() => {
          this.setState({ nome: '', sobrenome: '', dataNascimento: '', email: '', senha: '' });
          alert("Usuário e dados cadastrados com sucesso!");
          window.location.href = "/login";
        });
      })
      .catch((error) => {
        console.error("Erro no cadastro: ", error);
        alert("Erro: " + error.message);
      });
  }

  render() {
    return (
    <div>
      <h1>Cadastro</h1>
      <input type="text" placeholder="Nome" value={this.state.nome} onChange={(e) => this.setState({nome: e.target.value})} required />
      <br/>
      <input type="text" placeholder="Sobrenome" value={this.state.sobrenome} onChange={(e) => this.setState({sobrenome: e.target.value})} required />
      <br/>
      <input type="date" value={this.state.dataNascimento} onChange={(e) => this.setState({dataNascimento: e.target.value})} required />
      <br/>
      <input type="email" placeholder="E-mail" value={this.state.email} onChange={(e) => this.setState({email: e.target.value})} required />
      <br/>
      <input type="password" placeholder="Senha" value={this.state.senha} onChange={(e) => this.setState({senha: e.target.value})} required />
      <br/>
      <button onClick={this.gravar}>Cadastrar</button>
    </div>
  );
}
}

export default Cadastro;