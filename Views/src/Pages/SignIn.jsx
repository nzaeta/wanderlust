import React from 'react'
import { Link } from 'react-router-dom';
import ArrowForwardIosIcon from '@mui/icons-material/ArrowForwardIos';

function SignIn() {
  return (
    <div className="Main-Container" class="text-gray-300 bg-zinc-900 h-screen flex justify-center items-center">
      <div className='SignIn-Container' class="bg-gray-300 text-zinc-900 flex justify-center items-center h-[300px] w-[600px]">
        <div className="SignIn-Card" class="w-[500px] " >
          <div className="SignIn-Card_Form">
            <div className="SignIn-Card_Form__Top" class="flex justify-around items-center">
              <p>Iniciar Sesión</p>
              <Link to="/signUp" class="text-zinc-500">Registrarme</Link>
            </div>
            <div className="SignIn-Card_Form__Bottom" class="flex-col items-center">
              <input type="text" class="w-full my-10 p-1" placeholder='Usuario'/>
              <input type="email" class="w-full my-10 p-1" placeholder='Email'/>
            </div>
            <div class="flex justify-end" >
              <button class="bg-zinc-600 px-4 py-1 text-zinc-300 rounded-2xl flex justify-center items-center "> 
              <span class="pb-1">Iniciar Sesión</span>
              <ArrowForwardIosIcon fontSize="small"/> </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SignIn