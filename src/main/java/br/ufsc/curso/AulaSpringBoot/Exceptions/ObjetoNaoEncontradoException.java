
package br.ufsc.curso.AulaSpringBoot.Exceptions;

/**
 *
 * @author RC_Ventura
 */
public class ObjetoNaoEncontradoException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public ObjetoNaoEncontradoException (Object id){
        super("Objeto não encontrado" + id);
    }
    
}
