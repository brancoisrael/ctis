//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.20 at 04:47:57 PM BRST 
//


package br.jus.tream.saude.importacao.xml.V3_04_00;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ctm_consultaGuia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ctm_consultaGuia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabecalhoConsulta" type="{http://www.ans.gov.br/padroes/tiss/schemas}ct_guiaCabecalho"/>
 *         &lt;element name="numeroGuiaOperadora" type="{http://www.ans.gov.br/padroes/tiss/schemas}st_texto20" minOccurs="0"/>
 *         &lt;element name="ausenciaCodValidacao" type="{http://www.ans.gov.br/padroes/tiss/schemas}dm_ausenciaCodValidacao" minOccurs="0"/>
 *         &lt;element name="codValidacao" type="{http://www.ans.gov.br/padroes/tiss/schemas}st_texto10" minOccurs="0"/>
 *         &lt;element name="dadosBeneficiario" type="{http://www.ans.gov.br/padroes/tiss/schemas}ct_beneficiarioDados"/>
 *         &lt;element name="contratadoExecutante">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.ans.gov.br/padroes/tiss/schemas}ct_contratadoDados">
 *                 &lt;sequence>
 *                   &lt;element name="CNES" type="{http://www.ans.gov.br/padroes/tiss/schemas}st_texto7"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="profissionalExecutante" type="{http://www.ans.gov.br/padroes/tiss/schemas}ct_contratadoProfissionalDados"/>
 *         &lt;element name="indicacaoAcidente" type="{http://www.ans.gov.br/padroes/tiss/schemas}dm_indicadorAcidente"/>
 *         &lt;element name="dadosAtendimento" type="{http://www.ans.gov.br/padroes/tiss/schemas}ctm_consultaAtendimento"/>
 *         &lt;element name="observacao" type="{http://www.ans.gov.br/padroes/tiss/schemas}st_texto500" minOccurs="0"/>
 *         &lt;element name="assinaturaDigitalGuia" type="{http://www.ans.gov.br/padroes/tiss/schemas}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ctm_consultaGuia", propOrder = {
    "cabecalhoConsulta",
    "numeroGuiaOperadora",
    "ausenciaCodValidacao",
    "codValidacao",
    "dadosBeneficiario",
    "contratadoExecutante",
    "profissionalExecutante",
    "indicacaoAcidente",
    "dadosAtendimento",
    "observacao",
    "assinaturaDigitalGuia"
})
public class CtmConsultaGuia {

    @XmlElement(required = true)
    protected CtGuiaCabecalho cabecalhoConsulta;
    protected String numeroGuiaOperadora;
    protected String ausenciaCodValidacao;
    protected String codValidacao;
    @XmlElement(required = true)
    protected CtBeneficiarioDados dadosBeneficiario;
    @XmlElement(required = true)
    protected CtmConsultaGuia.ContratadoExecutante contratadoExecutante;
    @XmlElement(required = true)
    protected CtContratadoProfissionalDados profissionalExecutante;
    @XmlElement(required = true)
    protected String indicacaoAcidente;
    @XmlElement(required = true)
    protected CtmConsultaAtendimento dadosAtendimento;
    protected String observacao;
    protected Signature assinaturaDigitalGuia;

    /**
     * Gets the value of the cabecalhoConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link CtGuiaCabecalho }
     *     
     */
    public CtGuiaCabecalho getCabecalhoConsulta() {
        return cabecalhoConsulta;
    }

    /**
     * Sets the value of the cabecalhoConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtGuiaCabecalho }
     *     
     */
    public void setCabecalhoConsulta(CtGuiaCabecalho value) {
        this.cabecalhoConsulta = value;
    }

    /**
     * Gets the value of the numeroGuiaOperadora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroGuiaOperadora() {
        return numeroGuiaOperadora;
    }

    /**
     * Sets the value of the numeroGuiaOperadora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroGuiaOperadora(String value) {
        this.numeroGuiaOperadora = value;
    }

    /**
     * Gets the value of the ausenciaCodValidacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAusenciaCodValidacao() {
        return ausenciaCodValidacao;
    }

    /**
     * Sets the value of the ausenciaCodValidacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAusenciaCodValidacao(String value) {
        this.ausenciaCodValidacao = value;
    }

    /**
     * Gets the value of the codValidacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodValidacao() {
        return codValidacao;
    }

    /**
     * Sets the value of the codValidacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodValidacao(String value) {
        this.codValidacao = value;
    }

    /**
     * Gets the value of the dadosBeneficiario property.
     * 
     * @return
     *     possible object is
     *     {@link CtBeneficiarioDados }
     *     
     */
    public CtBeneficiarioDados getDadosBeneficiario() {
        return dadosBeneficiario;
    }

    /**
     * Sets the value of the dadosBeneficiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtBeneficiarioDados }
     *     
     */
    public void setDadosBeneficiario(CtBeneficiarioDados value) {
        this.dadosBeneficiario = value;
    }

    /**
     * Gets the value of the contratadoExecutante property.
     * 
     * @return
     *     possible object is
     *     {@link CtmConsultaGuia.ContratadoExecutante }
     *     
     */
    public CtmConsultaGuia.ContratadoExecutante getContratadoExecutante() {
        return contratadoExecutante;
    }

    /**
     * Sets the value of the contratadoExecutante property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtmConsultaGuia.ContratadoExecutante }
     *     
     */
    public void setContratadoExecutante(CtmConsultaGuia.ContratadoExecutante value) {
        this.contratadoExecutante = value;
    }

    /**
     * Gets the value of the profissionalExecutante property.
     * 
     * @return
     *     possible object is
     *     {@link CtContratadoProfissionalDados }
     *     
     */
    public CtContratadoProfissionalDados getProfissionalExecutante() {
        return profissionalExecutante;
    }

    /**
     * Sets the value of the profissionalExecutante property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtContratadoProfissionalDados }
     *     
     */
    public void setProfissionalExecutante(CtContratadoProfissionalDados value) {
        this.profissionalExecutante = value;
    }

    /**
     * Gets the value of the indicacaoAcidente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicacaoAcidente() {
        return indicacaoAcidente;
    }

    /**
     * Sets the value of the indicacaoAcidente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicacaoAcidente(String value) {
        this.indicacaoAcidente = value;
    }

    /**
     * Gets the value of the dadosAtendimento property.
     * 
     * @return
     *     possible object is
     *     {@link CtmConsultaAtendimento }
     *     
     */
    public CtmConsultaAtendimento getDadosAtendimento() {
        return dadosAtendimento;
    }

    /**
     * Sets the value of the dadosAtendimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtmConsultaAtendimento }
     *     
     */
    public void setDadosAtendimento(CtmConsultaAtendimento value) {
        this.dadosAtendimento = value;
    }

    /**
     * Gets the value of the observacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Sets the value of the observacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacao(String value) {
        this.observacao = value;
    }

    /**
     * Gets the value of the assinaturaDigitalGuia property.
     * 
     * @return
     *     possible object is
     *     {@link Signature }
     *     
     */
    public Signature getAssinaturaDigitalGuia() {
        return assinaturaDigitalGuia;
    }

    /**
     * Sets the value of the assinaturaDigitalGuia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature }
     *     
     */
    public void setAssinaturaDigitalGuia(Signature value) {
        this.assinaturaDigitalGuia = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.ans.gov.br/padroes/tiss/schemas}ct_contratadoDados">
     *       &lt;sequence>
     *         &lt;element name="CNES" type="{http://www.ans.gov.br/padroes/tiss/schemas}st_texto7"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cnes"
    })
    public static class ContratadoExecutante
        extends CtContratadoDados
    {

        @XmlElement(name = "CNES", required = true)
        protected String cnes;

        /**
         * Gets the value of the cnes property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCNES() {
            return cnes;
        }

        /**
         * Sets the value of the cnes property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCNES(String value) {
            this.cnes = value;
        }

    }

}