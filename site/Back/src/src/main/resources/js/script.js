//-----------FUNÇÕES DE NAVEGAÇÃO-------------------

//FUNÇÃO PARA RETORNAR A HOMEPAGE
function Home() {
    window.location.href = "/";
}

//FUNÇÃO PARA IR A TELA DE LOGIN
function Login() {
    window.location.href = "/login";
}

//FUNÇÃO PARA IR A TELA DE MYPROJECTS
function MyProjects() {
    window.location.href = "/myprojects";
}

//FUNÇÃO PARA IR A TELA DE CREATION
function Creation() {
    window.location.href = "/creation";
}

//FUNÇÃO PARA IR A TELA DO PROJETO
function Project( /*let x*/ ) {
    //Por enquanto temos apenas um projeto place holder, portanto, a variável x não será utilizada    
    window.location.href = "/project";
}

//FUNÇÃO PARA IR A TELA DE REGISTER
function Register() {
    window.location.href = "/register";
}



//----------FUNÇÕES DA TELA HOME-----------------






//---------FUNÇÕES DA TELA LOGIN-----------------






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
}

//FUNÇÃO PARA DESMARCAR OUTRAS OPÇÕES DE CHECKBOXES QUANDO UMA FOR MARCADA
function boxChecked(tag) {
    //Campos de Tag
    let adm = document.getElementById("adm-input");
    let eng = document.getElementById("eng-input");
    let ent = document.getElementById("ent-input");
    let sau = document.getElementById("sau-input");
    let tec = document.getElementById("tec-input");
    let out = document.getElementById("out-input");

    //Campos de requisito curricular
    let nenhum = document.getElementById("nenhum-input");
    let grad = document.getElementById("grad-input");
    let pos = document.getElementById("pos-input");
    let mestrado = document.getElementById("mestrado-input");
    let doutorado = document.getElementById("doutorado-input");

    switch (tag) {
        //Cases para Tags
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
            //Cases para requisito curricular
        case "nenhum":
            grad.checked = false;
            pos.checked = false;
            mestrado.checked = false;
            doutorado.checked = false;
            break;
        case "grad":
            nenhum.checked = false;
            pos.checked = false;
            mestrado.checked = false;
            doutorado.checked = false;
            break;
        case "pos":
            grad.checked = false;
            nenhum.checked = false;
            mestrado.checked = false;
            doutorado.checked = false;
            break;
        case "mestrado":
            grad.checked = false;
            pos.checked = false;
            nenhum.checked = false;
            doutorado.checked = false;
            break;
        case "doutorado":
            grad.checked = false;
            pos.checked = false;
            mestrado.checked = false;
            nenhum.checked = false;
            break;
        default:
            console.log("Error - Tag checking");
            break;
    }
}

//FUNÇÃO QUE TESTA SE O REGISTRO É VÁLIDO
function validRegister() {
    let valid = true;
    //Campos
    let nome = document.getElementById("user-input").value;
    let senha = document.getElementById("password-input").value;
    let cSenha = document.getElementById("c-password-input").value;
    let email = document.getElementById("email-input").value;
    let personal = document.getElementById("personal-input").checked;
    let business = document.getElementById("business-input").checked;
    let comprovante = document.getElementById("comprovante-input").value;

    //Assegurando que todos os campos foram preenchidos
    if (nome === "" || senha === "" || cSenha === "" || email === "") {
        valid = false;
        alert("Alguns campos não foram preenchidos.");
        return valid;
    }

    //Confirmando a senha
    if (senha !== cSenha) {
        valid = false;
        alert("As senhas não coincidem.");
        return valid;
    }

    //Assegurando que o tipo de conta foi selecionado
    if (!personal && !business) {
        valid = false;
        alert("Por favor, informe se sua conta será pessoal ou empresarial.");
        return valid;
    }

    //Assegurando que há comprovante de existência na conta empresarial
    if (business && comprovante === "") {
        valid = false;
        alert("É necessária a anexação do comprovante de existência.");
        return valid;
    }

    return valid;
}



//---------FUNÇÕES DA TELA CREATION-----------------

//FUNÇÃO DE CALCULAR CUSTO DO PROJETO
function Calculate() {
    let dur = document.getElementById("duration-input") || 0;
    let costText = document.getElementById("cost-text");
    let valid = true; //Variável para testar se o requisito curricular é válido

    //Campos de requisito curricular
    let nenhum = document.getElementById("nenhum-input").checked;
    let grad = document.getElementById("grad-input").checked;
    let pos = document.getElementById("pos-input").checked;
    let mestrado = document.getElementById("mestrado-input").checked;
    let doutorado = document.getElementById("doutorado-input").checked;

    //Cálculo com base na pauta
    let cost = dur.value * 20;

    //Cálculo com base no requisto
    if (nenhum) {
        cost *= 1;
    } else if (grad) {
        cost *= 10;
    } else if (pos) {
        cost *= 25;
    } else if (mestrado) {
        cost *= 50;
    } else if (doutorado) {
        cost *= 80;
    } else {
        valid = false;
    }

    costText.style.border = "2px solid whitesmoke";
    if (valid) {
        costText.innerHTML = "Custo: R$ " + cost;
    } else {
        costText.innerHTML = "Requisito curricular inválido";
    }
    return cost;
}

//FUNÇÃO PARA REGISTRAR O USUÁRIO NO BANCO DE DADOS
function registroUsuario() {
    //Testa se o formulário está válido
    if (validRegister()) {
        let personal = document.getElementById("personal-input");
        let business = document.getElementById("business-input");
        let nome = document.getElementById("user-input").value;
        let senha = document.getElementById("password-input").value;
        let email = document.getElementById("email-input").value;
        let file = document.getElementById("comprovante-input").value;
        let methodGet = {
            method: "GET"
        };

        //Se for uma conta pessoal
        if (personal.checked) {
            let tag;
            let adm = document.getElementById("adm-input");
            let eng = document.getElementById("eng-input");
            let ent = document.getElementById("ent-input");
            let sau = document.getElementById("sau-input");
            let tec = document.getElementById("tec-input");
            let out = document.getElementById("out-input");
            if (adm.checked) {
                tag = "adm";
            } else if (eng.checked) {
                tag = "eng";
            } else if (ent.checked) {
                tag = "ent";
            } else if (sau.checked) {
                tag = "sau";
            } else if (tec.checked) {
                tag = "tec";
            } else {
                tag = "out";
            }

            i++;
            fetch(`http://localhost:4567/mandarRe?query=${nome},${senha},${email},${file},${tag},${i}`, methodGet);
        } else if (business.checked) { //Se for uma conta empresarial
            e++;
            fetch(`http://localhost:4567/empresaRe?query=${nome},${senha},${email},${file},${e}`, methodGet);
        }
    }
}

//FUNÇÃO PARA CRIAR O PROJETO E ENVIAR PARA O BANCO DE DADOS
function createProject() {
    if (validProject()) {
        let nome = document.getElementById("title-input").value;
        let duracao = document.getElementById("duration-input").value;
        let custo = Calculate();
        let descricao = document.getElementById("description-input").value;
        let file = document.getElementById("images-input").value;
        let tag;
        let requisito;
        let methodGet = {
            method: "GET"
        };

        //Campos de Tag
        let adm = document.getElementById("adm-input");
        let eng = document.getElementById("eng-input");
        let ent = document.getElementById("ent-input");
        let sau = document.getElementById("sau-input");
        let tec = document.getElementById("tec-input");
        let out = document.getElementById("out-input");

        //Campos de requisito curricular
        let nenhum = document.getElementById("nenhum-input");
        let grad = document.getElementById("grad-input");
        let pos = document.getElementById("pos-input");
        let mestrado = document.getElementById("mestrado-input");
        let doutorado = document.getElementById("doutorado-input");

        //Tag
        if (adm.checked) {
            tag = "adm";
        } else if (eng.checked) {
            tag = "eng";
        } else if (ent.checked) {
            tag = "ent";
        } else if (sau.checked) {
            tag = "sau";
        } else if (tec.checked) {
            tag = "tec";
        } else {
            tag = "out";
        }

        //Requisito
        if (nenhum.checked) {
            requisito = "nenhum"
        } else if (grad.checked) {
            requisito = "grad";
        } else if (pos.checked) {
            requisito = "pos";
        } else if (mestrado.checked) {
            requisito = "mestrado";
        } else if (doutorado.checked) {
            requisito = "doutorado";
        } else {
            requisito = "nenhum";
        }

        saberOidProjeto++;
        fetch(`http://localhost:4567/projetoRe?query=${nome}//${duracao}//${custo}//${tag}//${descricao}//${requisito}//${saberOidProjeto}//${file}`, methodGet).then();
    }
}

//FUNÇÃO QUE VALIDA O PROJETO
function validProject() {
    let valid = true;
    //Campos
    let nome = document.getElementById("title-input").value;
    let duracao = document.getElementById("duration-input").value;
    let file = document.getElementById("images-input").value;

    if (nome == "" || duracao == "" || file == "") {
        valid = false;
        alert("Alguns campos não foram preenchidos.");
        return valid;
    }

    if (duracao < 1) {
        valid = false;
        alert("Duração do projeto inválida.");
        return valid;
    }

    return valid;
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





//-----------FUNÇÕES DA TELA MYCOMMENTS---------------





//-----------FUNÇÕES DA TELA LOGOUT------------------







//-----------FUNÇÕES E VARIÁVEIS DE TESTE---------------
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
let e = 0;
var saberOidProjeto = 0;