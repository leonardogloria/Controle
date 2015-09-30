package controle



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FabricanteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Fabricante.list(params), model:[fabricanteInstanceCount: Fabricante.count()]

        def lista = ['Teste','Teste2','Teste3']






    }

    def show(Fabricante fabricanteInstance) {
        respond fabricanteInstance
    }

    def create() {
        respond new Fabricante(params)
    }

    @Transactional
    def save(Fabricante fabricanteInstance) {
        if (fabricanteInstance == null) {
            notFound()
            return
        }

        if (fabricanteInstance.hasErrors()) {
            respond fabricanteInstance.errors, view:'create'
            return
        }

        fabricanteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fabricante.label', default: 'Fabricante'), fabricanteInstance.id])
                redirect fabricanteInstance
            }
            '*' { respond fabricanteInstance, [status: CREATED] }
        }
    }

    def edit(Fabricante fabricanteInstance) {
        respond fabricanteInstance
    }

    @Transactional
    def update(Fabricante fabricanteInstance) {
        if (fabricanteInstance == null) {
            notFound()
            return
        }

        if (fabricanteInstance.hasErrors()) {
            respond fabricanteInstance.errors, view:'edit'
            return
        }

        fabricanteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Fabricante.label', default: 'Fabricante'), fabricanteInstance.id])
                redirect fabricanteInstance
            }
            '*'{ respond fabricanteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Fabricante fabricanteInstance) {

        if (fabricanteInstance == null) {
            notFound()
            return
        }

        fabricanteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Fabricante.label', default: 'Fabricante'), fabricanteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fabricante.label', default: 'Fabricante'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
