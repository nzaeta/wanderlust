import React from 'react'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';

function Navbar() {
  return (
    <div className="Navbar-Container" class="bg-zinc-300">
        <div className="Navbar-Top" class="top-0  w-full h-20 flex justify-between px-8 items-center ">
            <div className="Navbar-Top_Left">
            <Link to="/">WANDERLUST</Link>
            </div>
            <div className="Navbar-Top_Right" class="flex justify-end">
                <div className="Navbar-Top_Right__SignIn" class="px-8">
                <Link to="/signIn">Iniciar Sesión</Link>
                </div>
                <div className="Navbar-Top_Right__SignUp" class="px-8">
                <Link to="/signUp">Registrarme</Link>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Navbar