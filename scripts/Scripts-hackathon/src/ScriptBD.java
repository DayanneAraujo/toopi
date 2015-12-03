import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ScriptBD {
	public static List<String> generateInsertLicitacoes() throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("inserts-licitacoes.txt", "UTF-16");
		ArrayList<String> data = new ArrayList<>();
		StringTokenizer st;
		
		try(BufferedReader br = new BufferedReader(new FileReader("x.csv"))){
			 String currentData;
			 String element;
			 while ((currentData = br.readLine()) != null){
				 System.out.println(currentData);
				 //get empty elements
				 st = new StringTokenizer(currentData, ";");
				 int pos = 0;
				 String finalData = new String();
				 while (st.hasMoreElements() && pos <31) {
					pos++;
					element = (String) st.nextElement();
					if(element.equals("")){
						finalData = finalData.concat("`null`");
					} else{
						if (pos < 31){
							finalData = finalData.concat("`" + element +"`" + ",");
						}
						else{
							finalData = finalData.concat("`" + element + "`");
						}
					}
				}

				 writer.println("INSERT INTO `harpia`.`licitacao` (`id`, `dataAberturaProposta`, `dataEntregaEdital`, `dataProposta`, `dataPublicação`, `endereçoEntrgaEdital`, `funcaoResponsavel`, `identificador`, `infoGeral`,`modalidade`, `nomeResponsavel`, `numeroAviso`, `numeroItens`, `numeroProcesso`, `objeto`, `situacaoAviso`, `tipoPregao`, `tipoRecurso`, `uasg`, `unidade`, `valor_estimado`, `situacao`) VALUES ( " + finalData + ");");
				 System.out.println(currentData);
				 data.add(currentData);
			 }
			 writer.close();
			 
		} catch(Exception e){}
		
		return data;
	}
	
	public static List<String> generateInsertItens() throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("inserts-itens.txt", "UTF-16");
		ArrayList<String> data = new ArrayList<>();
		StringTokenizer st;
		
		try(BufferedReader br = new BufferedReader(new FileReader("cafe.csv"))){
			 String currentData;
			 String element;
			 while ((currentData = br.readLine()) != null){
				 System.out.println(currentData);
				 //get empty elements
				 st = new StringTokenizer(currentData, ";");
				 int pos = 0;
				 String finalData = new String();
				 while (st.hasMoreElements()) {
					pos++;
					if (pos > 18){
					element = (String) st.nextElement();
						if(element.equals("")){
							finalData = finalData.concat("`null`");
						} else{
							if (pos < 51){
								finalData = finalData.concat("`" + element +"`" + ",");
							}
							else{
								finalData = finalData.concat("`" + element + "`");
							}
						}
					}
				}
				 
				 currentData = currentData.replaceAll(";", ",");
				 writer.println("INSERT INTO `harpia`.`itenslicitacao` (`id`, `beneficio`, `cnpj_fornecedor`, `codigo_item_material`, `codigo_item_servico`, `cpfVencedor`, `criterio_julgamento`, `decreto_7174`, `descricao_item`, `modalidade`, `numero_aviso`, `numero_item_licitacao`, `numero_licitacao`, `quantidade`, `sustentavel`, `uasg`, `unidade`, `valor_estimado`, `situacao`) VALUES ( " + finalData + ");");
				 System.out.println(currentData);
				 data.add(currentData);
			 }
			 writer.close();
			 
		} catch(Exception e){}
		
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(generateInsertLicitacoes());
		System.out.println(generateInsertItens());
	}
}
