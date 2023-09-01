import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import { useState } from 'react'
import './App.css'
import Home from './Pages/Home'
import Navbar from './Components/Navbar'
import SignIn from './Pages/Signin';
import SignUp from './Pages/SignUp';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <BrowserRouter>
      <Navbar/>
      {/* <Lowbar/> */}
      <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signIn" element={<SignIn />} />
            <Route path="/signUp" element={<SignUp />} />
          </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
