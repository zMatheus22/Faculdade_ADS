import { useEffect, useState } from 'react';
import { auth, db } from '../../firebaseConnection';
import { onAuthStateChanged, signOut } from 'firebase/auth';
import { doc, getDoc } from 'firebase/firestore';
import { useNavigate } from 'react-router-dom';
import "../../index.css";

export default function Home() {
  const [userDetails, setUserDetails] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    async function checkLogin() {
      onAuthStateChanged(auth, async (user) => {
        if (user) {
          const docRef = doc(db, "usuario", user.uid);
          const docSnap = await getDoc(docRef);

          if (docSnap.exists()) {
            setUserDetails(docSnap.data());
          }
        } else {
          navigate('/');
        }
      });
    }

    checkLogin();
  }, [navigate]);

  async function handleLogout() {
    await signOut(auth);
    navigate('/login');
  }

  return (
    <div>
      <h1>Página Principal</h1>
      {userDetails && (
        <div>
          <p><strong>Nome:</strong> {userDetails.nome}</p>
          <p><strong>Sobrenome:</strong> {userDetails.sobrenome}</p>
          <p><strong>Data de Nascimento:</strong> {userDetails.dataNascimento}</p>
        </div>
      )}
      <button onClick={handleLogout}>Sair</button>
    </div>
  );
}
