import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.jus.tream.saude.importacao.xml.V3_04_00.MensagemTISS;

public class Teste {

	public static void main(String[] args) throws Exception {
		 JAXBContext jaxbContext = JAXBContext.newInstance(MensagemTISS.class);
	        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

	        MensagemTISS venda = (MensagemTISS) unmarshaller.unmarshal(new FileInputStream("src/teste.xml"));
	        System.out.println(venda.getCabecalho().getIdentificacaoTransacao().getDataRegistroTransacao());
	}
}
