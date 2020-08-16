package Models;

public class Afiliado {
    
    private String tipoDocumento;
    private long numeroDocumento;
    private String tipoAfiliacion;
    private String estado;
    private String categoria;
    private String tipoDocumentoAfiliado;
    private long numeroDocumentoAfiliado;
    
    public Afiliado(String doc, long numero, String tipoafi, String estado, String catego, String tipoDocAfi, long nroDocAfi) {
        tipoDocumento = doc;
        numeroDocumento = numero;
        tipoAfiliacion = tipoafi;
        this.estado = estado;
        categoria = catego;
        tipoDocumentoAfiliado = tipoDocAfi;
        numeroDocumentoAfiliado = nroDocAfi;
    }
    
    public Afiliado(String doc, long numero, String tipoafi, String estado, String catego) {
        tipoDocumento = doc;
        numeroDocumento = numero;
        tipoAfiliacion = tipoafi;
        this.estado = estado;
        categoria = catego;
        tipoDocumentoAfiliado = null;
        numeroDocumentoAfiliado = 0;
    }
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    public long getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public String getTipoAfiliacion() {
        return tipoAfiliacion;
    }
    
    public void setTipoAfiliacion(String tipoAfiliacion) {
        this.tipoAfiliacion = tipoAfiliacion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getTipoDocumentoAfiliado() {
        return tipoDocumentoAfiliado;
    }
    
    public void setTipoDocumentoAfiliado(String tipoDocumentoAfiliado) {
        this.tipoDocumentoAfiliado = tipoDocumentoAfiliado;
    }
    
    public long getNumeroDocumentoAfiliado() {
        return numeroDocumentoAfiliado;
    }
    
    public void setNumeroDocumentoAfiliado(long numeroDocumentoAfiliado) {
        this.numeroDocumentoAfiliado = numeroDocumentoAfiliado;
    }
    
}
