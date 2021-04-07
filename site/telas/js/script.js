//-----------FUNÇÕES GERAIS-------------------

//FUNÇÃO PARA RETORNAR A HOMEPAGE
function Home() {
    window.location.href = "http://127.0.0.1:5500/home.html";
}


//FUNÇÃO PARA IR A TELA DE LOGIN
function Login() {
    window.location.href = "http://127.0.0.1:5500/login.html";
}



//----------FUNÇÕES DA TELA HOME-----------------


//FUNÇÃO PARA IR A TELA DE MYPROJECTS
function MyProjects() {
    window.location.href = "http://127.0.0.1:5500/myprojects.html";
}


//FUNÇÃO PARA IR A TELA DE CREATION
function Creation() {
    window.location.href = "http://127.0.0.1:5500/creation.html";
}


//FUNÇÃO PARA IR A TELA DO PROJETO
function Project( /*let x*/ ) {
    //Por enquanto apenas teremos um projeto place holder, portanto, a variável x não será utilizada    
    window.location.href = "http://127.0.0.1:5500/project.html";
}



//---------FUNÇÕES DA TELA LOGIN-----------------


//FUNÇÃO PARA IR A TELA DE REGISTER
function Register() {
    window.location.href = "http://127.0.0.1:5500/register.html";
}



//--------FUNÇÕES DA TELA REGISTER---------------





//---------FUNÇÕES DA TELA CREATION-----------------





//----------FUNÇÕES DA TELA PROJECTS-------------


//FUNÇÃO PARA APARECER A TELA DE COMENTAR
//Essa função muda o botão de "comentar" para "cancelar" e vice-versa
//Também faz aparecer e desaparecer o botão de postar comentário
function ShowComment() {
    let x = document.getElementById("comment");
    let c = document.getElementById("show-comment-button");
    let p = document.getElementById("post-comment-button");
    if (c.innerHTML === "Comentar") {
        c.innerHTML = "Cancelar";
        x.style.display = "flex";
        p.style.display = "block"
    } else {
        c.innerHTML = "Comentar";
        x.style.display = "none";
        p.style.display = "none";
    }
}




//-----------FUNÇÕES DA TELA MYPROJECTS--------------