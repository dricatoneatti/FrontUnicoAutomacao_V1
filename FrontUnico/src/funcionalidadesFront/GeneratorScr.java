package funcionalidadesFront;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GeneratorScr {
	public static String dataHoraArquivo() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(ts);
	}

}
