//-----------FUNÇÕES GERAIS-------------------

//FUNÇÃO PARA RETORNAR A HOMEPAGE
function Home() {
    window.location.href = "/";
}


//FUNÇÃO PARA IR A TELA DE LOGIN
function Login() {
    window.location.href = "/login";
}



//----------FUNÇÕES DA TELA HOME-----------------


//FUNÇÃO PARA IR A TELA DE MYPROJECTS
function MyProjects() {
    window.location.href = "/myprojects";
}


//FUNÇÃO PARA IR A TELA DE CREATION
function Creation() {
    window.location.href = "/creation";
}


//FUNÇÃO PARA IR A TELA DO PROJETO
function Project( /*let x*/) {
    //Por enquanto temos apenas um projeto place holder, portanto, a variável x não será utilizada    
    window.location.href = "/project";
}



//---------FUNÇÕES DA TELA LOGIN-----------------


//FUNÇÃO PARA IR A TELA DE REGISTER
function Register() {
    window.location.href = "/register";
}



//--------FUNÇÕES DA TELA REGISTER---------------

//FUNÇÃO PARA APARECER A TAG E O COMPROVANTE CURRICULAR SE A CONTA FOR PESSOAL

function isPersonal() {
    let personal = document.getElementById("personal-input");
    let business = document.getElementById("business-input");
    let tag = document.getElementById("tag-div");
    let comprovante = document.getElementById("comprovante-div");
    let comprovanteLabel = document.getElementById("comprovante-label");

    //Desmarcar opção empresarial
    if (business.checked) {
        business.checked = false;
    }

    //Caso o usuário esteja marcando a opção de conta pessoal
    if (personal.checked) {
        tag.style.display = "block";
        comprovante.style.display = "block";
        comprovanteLabel.innerHTML = "Comprovante Curricular (se algum)";
    } else { //Caso o usuário esteja desmarcando a opção de conta pessoal
        tag.style.display = "none";
        comprovante.style.display = "none";
    }


}

//FUNÇÃO PARA APARECER O COMPROVANTE DE EXISTÊNCIA SE A CONTA FOR EMPRESARIAL
function isBusiness() {
    let personal = document.getElementById("personal-input");
    let business = document.getElementById("business-input");
    let tag = document.getElementById("tag-div");
    let comprovante = document.getElementById("comprovante-div");
    let comprovanteLabel = document.getElementById("comprovante-label");

    //Desmarcar opção pessoal
    if (personal.checked) {
        personal.checked = false;
    }

    //Caso o usuário esteja marcando a opção de conta empresarial
    if (business.checked) {
        tag.style.display = "none";
        comprovante.style.display = "block";
        comprovanteLabel.innerHTML = "Comprovante de Existência";
    } else { //Caso o usuário esteja desmarcando a opção de conta empresarial
        comprovante.style.display = "none";
    }
    foiativadaU = false;

}

//FUNÇÃO PARA DESMARCAR OUTRAS OPÇÕES DE TAG QUANDO UMA FOR MARCADA
function tagChecked(tag) {
    let adm = document.getElementById("adm-input");
    let eng = document.getElementById("eng-input");
    let ent = document.getElementById("ent-input");
    let sau = document.getElementById("sau-input");
    let tec = document.getElementById("tec-input");
    let out = document.getElementById("out-input");

    switch (tag) {
        case "adm":
            eng.checked = false;
            ent.checked = false;
            sau.checked = false;
            tec.checked = false;
            out.checked = false;
            break;
        case "eng":
            adm.checked = false;
            ent.checked = false;
            sau.checked = false;
            tec.checked = false;
            out.checked = false;
            break;
        case "ent":
            eng.checked = false;
            adm.checked = false;
            sau.checked = false;
            tec.checked = false;
            out.checked = false;
            break;
        case "sau":
            eng.checked = false;
            ent.checked = false;
            adm.checked = false;
            tec.checked = false;
            out.checked = false;
            break;
        case "tec":
            eng.checked = false;
            ent.checked = false;
            sau.checked = false;
            adm.checked = false;
            out.checked = false;
            break;
        case "out":
            eng.checked = false;
            ent.checked = false;
            sau.checked = false;
            tec.checked = false;
            adm.checked = false;
            break;
        default:
            console.log("Error - Tag checking");
            break;
    }
}


//---------FUNÇÕES DA TELA CREATION-----------------

//FUNÇÃO DE CALCULAR CUSTO DO PROJETO
function Calculate() {
    let dur = document.getElementById("duration-input") || 0;
    let req = document.getElementById("requirement-input");
    let costText = document.getElementById("cost-text");
    let valid = true; //Variável para testar se o requisito curricular é válido

    //Cálculo com base na pauta
    let cost = dur.value * 20;

    //Cálculo com base no requisto
    switch (req.value) {
        case "Nenhum":
            cost *= 1;
            break;
        case "Graduação":
            cost *= 10;
            break;
        case "Pós-Graduação":
            cost *= 25;
            break;
        case "Mestrado":
            cost *= 50;
            break;
        case "Doutorado":
            cost *= 80;
            break;
        default:
            valid = false;
            break;
    }

    costText.style.border = "2px solid whitesmoke";
    if (valid) {
        costText.innerHTML = "Custo: R$ " + cost;
    } else {
        costText.innerHTML = "Requisito curricular inválido";
    }

}



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

function Testar() {
    //event.preventDefault();
    //console.log("ola");
    var pegar = window.document.getElementById("teste").value;
    var init = {
        method: 'GET'
    };
    fetch(`http://localhost:4567/pesquisa?query=${pegar}`, init);


}


let i = 0;
//-----------FUNÇÕES DA TELA MYCOMMENTS---------------




function registroUsuario() {
    let personal = document.getElementById("personal-input");
    let business = document.getElementById("business-input");

    if (personal.checked) {
        var nomeUsuarioP = window.document.getElementById("user-input").value;
        var senhaUsuarioP = window.document.getElementById("password-input").value;
        var emailUsuarioP = window.document.getElementById("email-input").value;
        var fileUsuario = window.document.getElementById("fileUsuario").value;

        let adm = document.getElementById("adm-input");
        let eng = document.getElementById("eng-input");
        let ent = document.getElementById("ent-input");
        let sau = document.getElementById("sau-input");
        let tec = document.getElementById("tec-input");
        let out = document.getElementById("out-input");

        let tagUsuario;
        if (adm.checked) {
            tagUsuario = "adm";
        }
        else if (eng.checked) {
            tagUsuario = "eng";
        }
        else if (ent.checked) {
            tagUsuario = "ent";
        }
        else if (sau.checked) {
            tagUsuario = "sau";
        }
        else if (tec.checked) {
            tagUsuario = "tec";
        }
        else {
            tagUsuario = "out"
        }

        i++;
        var fazer = {
            method: 'GET'
        };
        fetch(`http://localhost:4567/mandarRe?query=${nomeUsuarioP},${senhaUsuarioP},${emailUsuarioP},${fileUsuario},${tagUsuario},${i}`, fazer);

    }


}

