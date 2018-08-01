package funcionalidadesFront;

import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LerExcel {
	public static ArrayList<String> leituraCartao(int numCartoes) throws Exception {
		// Localizar o caminho do arquivo Excel. (Alterar para o proprio de referencia)
		FileInputStream diretorio = new FileInputStream("C:\\Users\\640244\\Documents\\IniciativaCSF\\Cartoes.xlsx");
		// Criar a vari�vel "wb" do tipo WorkBook.
		XSSFWorkbook wb = new XSSFWorkbook(diretorio);
		XSSFSheet aba = wb.getSheet("Sheet1");
		// Gerar o Iterator
		java.util.Iterator<Row> IteratorDeLinha = aba.iterator();
		
		// Instanciar a vari�vel "list" do tipo ArrayList
		ArrayList<String> list = new ArrayList<String>();
		// Usar um loop para adicionar todos os dados da coluna do excel no Array "list
		while (IteratorDeLinha.hasNext()) { // o while continuar� o loop enquanto houver uma c�lula preenchida.
			list.add(IteratorDeLinha.next().getCell(numCartoes).getStringCellValue());
		}
		System.out.println(list);
		wb.close();
		return list;
	}
}
