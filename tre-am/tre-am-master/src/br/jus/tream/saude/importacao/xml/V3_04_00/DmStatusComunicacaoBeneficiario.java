//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.20 at 04:47:57 PM BRST 
//


package br.jus.tream.saude.importacao.xml.V3_04_00;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dm_statusComunicacaoBeneficiario.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dm_statusComunicacaoBeneficiario">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dm_statusComunicacaoBeneficiario")
@XmlEnum
public enum DmStatusComunicacaoBeneficiario {

    P,
    B;

    public String value() {
        return name();
    }

    public static DmStatusComunicacaoBeneficiario fromValue(String v) {
        return valueOf(v);
    }

}
