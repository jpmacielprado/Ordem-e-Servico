package local.jotape.OSApiApplication.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        
        ProblemaException problema = new ProblemaException();
        problema.setStatus(status.value());
        problema.setTitulo("Um ou mais campos inválidos! Tente novamente.");
        problema.setDatahora(LocalDateTime.now());
        
        List<ProblemaException.CampoProblema> camposComErro = new ArrayList<ProblemaException.CampoProblema>();
        
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nomeCampo = ((FieldError) error).getField();
            String mensagemCampo = error.getDefaultMessage();
            
            camposComErro.add(new ProblemaException.CampoProblema(nomeCampo, mensagemCampo) );
            
        }
        
        problema.setCampos(camposComErro);
        
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
    
    
}
