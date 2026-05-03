import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Cadastro from './paginas/Cadastro';
import Login from './paginas/Login';
import Home from './paginas/Home';

function RoutesApp() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/cadastro" element={<Cadastro />} />
      </Routes>
    </BrowserRouter>
  );
}

export default RoutesApp;