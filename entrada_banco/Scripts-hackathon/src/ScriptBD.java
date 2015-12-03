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
		PrintWriter writer = new PrintWriter("inserts-licitacoes.txt", "utf-8");
		ArrayList<String> data = new ArrayList<>();
		StringTokenizer st;
		
		try(BufferedReader br = new BufferedReader(new FileReader("xxx.csv"))){
			 String currentData;
			 String element;
			 while ((currentData = br.readLine()) != null){
				 System.out.println(currentData);
				 //get empty elements
				 st = new StringTokenizer(currentData, ";");
				 int pos = 0;
				 
//				 String a = (String) st.nextElement();
				 
//				 if(a.equals("id"))
//					 continue;
				 String finalData = new String();
				 while (st.hasMoreElements() && pos <19) {
					pos++;
					element = (String) st.nextElement();
					if(pos > 0 && pos < 5){
						element = element.replaceAll("T", " ");
						element = element.replaceAll("/", "-");
					}
						
					if(pos == 13){
						element = element.replaceAll("NA", "0");
					}
					if(element.equals("")){
						finalData = finalData.concat("`null`");
					} else{
						if (pos < 19){
							finalData = finalData.concat("'" + element +"'" + ",");
						}
						else{
							finalData = finalData.concat("'" + element + "'");
						}
					}
				}

				 writer.println("INSERT INTO harpia.licitacao (id, dataAberturaProposta, dataEntregaEdital, dataProposta, dataPublicação, endereçoEntrgaEdital, funcaoResponsavel, identificador, infoGeral,modalidade, nomeResponsavel, numeroAviso, numeroItens, numeroProcesso, objeto, situacaoAviso, tipoPregao, tipoRecurso, uasg) VALUES ( " + finalData + ");");
				 System.out.println(currentData);
				 data.add(currentData);
			 }
			 writer.close();
			 
		} catch(Exception e){}
		
		return data;
	}
	
	public static List<String> generateInsertItens() throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("inserts-itens.txt", "utf-8");
		ArrayList<String> data = new ArrayList<>();
		StringTokenizer st;
		
		try(BufferedReader br = new BufferedReader(new FileReader("xxx.csv"))){
			 String currentData;
			 String element;
			 while ((currentData = br.readLine()) != null){
				 System.out.println(currentData);
				 //get empty elements
				 st = new StringTokenizer(currentData, ";");
				 int pos = 0;
				 
//				 String a = (String) st.nextElement();
				 
//				 if(a.equals("id"))
//					 continue;
				 String finalData = new String();
				 while (st.hasMoreElements()) {
					pos++;
					element = (String) st.nextElement();
//					if(pos > 0 && pos < 5){
//						element = element.replaceAll("T", " ");
//						element = element.replaceAll("/", "-");
//					}
						
//					if(pos == 13){
//						element = element.replaceAll("NA", "0");
					if(element.equals("") && pos >= 19){
						finalData = finalData.concat("`null`");
					} else{
						if (pos > 19){
							if(pos == 22 || pos == 26 || pos == 31 || pos == 32 || pos == 34){
								 if(element.equals("NA"))
									 finalData = finalData.concat(0 + ",");
								 else
									 finalData = finalData.concat(element.replaceAll(",", ".") + ",");
								 
							}
							else
								finalData = finalData.concat("'" + element +"'" + ",");
						}
//						else{
//							finalData = finalData.concat("'" + element + "'");
//						}
					}
				}

				 writer.println("INSERT INTO harpia.itenslicitacao (descricao_item, quantidade_item, valor_estimado_item, descricao_detalhada_item, margem_preferencial, situacao_item, menor_lance, decreto_7174, fornecedor_vencedor, tratamento_diferenciado, unidade_fornecimento, valor_negociado, valor_final, url_pregao, valor_item, tipo_material, situacao) VALUES ( " + finalData + ");");
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
