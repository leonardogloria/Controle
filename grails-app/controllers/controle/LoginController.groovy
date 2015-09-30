package controle

class LoginController {

    def index() {}

    def doLogin(Usuario usuario){
        def usuarioBanco = Usuario.findByLoginAndSenha(usuario.login,usuario.senha)
        if(usuarioBanco){
           redirect controller: "produto", action: "index"
        }else{
            flash.message = "Usuario ou senha inválidos!"
           redirect action: 'index'
        }

    }
}
