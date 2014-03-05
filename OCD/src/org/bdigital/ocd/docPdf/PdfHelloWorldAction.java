package org.bdigital.ocd.docPdf;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.cases.CaseFormStaticDetailsAction;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FilterInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ernest Pastor
 *
 */
public class PdfHelloWorldAction extends Action {
	
	public static String TAGs [][] = new String [30][3];
    
    private static final int pag_actual = 1;
    private static final int pag_totals = 1;
   
    private static Font LletraNormalNegreta12;
    private static Font LletraNormal;
    private static Font LletraNormal10;
    private static Font Lletra6;
    
	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		Document documento = new Document();
		try{
			
			//Registrem les fonts a usar en l'Informe
	        registraFontsText();
	        
	        //Triem la llengua amb que realitzarem l'Informe
	        //int llengua = triaLlenguaInforme();  
	        int llengua = 0;
	        			
			response.setContentType("application/pdf");
			
			PdfWriter writer = PdfWriter.getInstance(documento, response.getOutputStream());
			
			//documento.open();
			
			//Procedim a realitzar totes les parts de l'Informe
	        procesaInforme(request, documento, llengua, writer);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//documento.close();
		return null;
	}
	
	/**
     * Afegeix la imatge del Hospital Clinic en l'extrem superior esquerra
     */
    private void afegirImatgeClinic(HttpServletRequest request,Document documento) throws IOException, DocumentException {
    	
    	String path = request.getServletContext().getRealPath("img\\hospital.jpg");
    	
    	Image foto = Image.getInstance(path);
        foto.scaleToFit(125, 75);
        foto.setAlignment(Chunk.HEADER);
        documento.add(foto);
    	
    }
    
    /**
     * Crea i inicialitza la matriu de TAGs
     */
    private static void setTAGs() {
        TAGs[0][0]="TITOL: ";
        TAGs[1][0]="Pacient: ";
        TAGs[2][0]="NHC:";
        TAGs[3][0]="Sexo/Sexe:";
        TAGs[4][0]="Fecha nac./Data naix.:";
        TAGs[5][0]="Edad/Edat:";
        TAGs[6][0]="Dirección/Adreça:";
        TAGs[7][0]="CP:";
        TAGs[8][0]="Municip. (Prov.):";
        TAGs[9][0]="ABS:";
        TAGs[10][0]="Tel.:";
        TAGs[11][0]="As.:";
        TAGs[12][0]="CIP:";
        TAGs[13][0]="NASS:";
        TAGs[14][0]="Nº epis.:";
        TAGs[15][0]="Tipo/Tipus:";
        TAGs[16][0]="Ingres.:";
        TAGs[17][0]="Serv:";
        TAGs[18][0]="UO Enf.:";
        TAGs[19][0]="Hora:";
        TAGs[20][0]="Facult. de ref.:";
        TAGs[21][0]="Realización/Realització";
        TAGs[22][0]="Fecha/Data:";
        TAGs[23][0]="Hora:";
        TAGs[24][0]="Nº:";
        TAGs[25][0]="INFORME";
        TAGs[26][0]="Resultados / Resultats";
        TAGs[27][0]="Resultats-Comentaris:";
        TAGs[28][0]="DIAGNOSTICO FINAL";
        TAGs[29][0]="";
        
        TAGs[0][2]="TITLE: ";
        TAGs[1][2]="Patient: ";
        TAGs[2][2]="NHC:";
        TAGs[3][2]="Gender:";
        TAGs[4][2]="Date of birth:";
        TAGs[5][2]="Age:";
        TAGs[6][2]="Address:";
        TAGs[7][2]="Postcode:";
        TAGs[8][2]="Town:";
        TAGs[9][2]="ABS:";
        TAGs[10][2]="Tel.:";
        TAGs[11][2]="As.:";
        TAGs[12][2]="CIP:";
        TAGs[13][2]="NASS:";
        TAGs[14][2]="Nº epis.:";
        TAGs[15][2]="Type:";
        TAGs[16][2]="Entry:";
        TAGs[17][2]="Serv:";
        TAGs[18][2]="UO Nurse.:";
        TAGs[19][2]="Hour:";
        TAGs[20][2]="Physician of reference:";
        TAGs[21][2]="Realization";
        TAGs[22][2]="Date:";
        TAGs[23][2]="Hour:";
        TAGs[24][2]="Nº:";
        TAGs[25][2]="REPORT";
        TAGs[26][2]="Results";
        TAGs[27][2]="Results-Comments:";
        TAGs[28][2]="FINAL DIAGNOSIS";
        TAGs[29][2]="";
    }
    
    /**
     * Entrem els TAGs per pantalla
     */
    private static void entradaDadesPerConsola() throws IOException {
        //Introduim la ruta del fitxer a parsejar per consola
        for (int i = 0; i < TAGs.length-1; i++) {
            //El camp 21 -Resultados/Resultats- només és un TAG, no té dades
            if(i!=21){
                System.out.println("Introdueix el valor del camp "+TAGs[i][0]);
                BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
                TAGs[i][1] = lectura.readLine();
            }
        }
        System.out.println("===FI D'INTRODUCCIÓ DELS CAMPS "); 
    }
    
    /**
     * Imprimeix la matriu de TAGs amb la seva informació corresponent
     */
    private static void imprimeixTAGs() {
        System.out.println("--->IMPRIMIM EL DICCIONARI DE TAGs");
        for (int i = 0; i <= 28; i++) {
            for (int j = 0; j <= 1; j++) {
                System.out.print(TAGs[i][j]+"\t");
            }
            System.out.println("");
        }
    }

    /**
     * Crea la matriu de TAGs, captura les dades per consola i els imprimeix per consola
     */
    private static void setGetTAGs() throws IOException {
        setTAGs();
        entradaDadesHardcoded();
        //entradaDadesPerConsola();
        //imprimeixTAGs();    
    }

    /**
     * Crea la capçalera del Document
     */
    private static void setCapcalera(Document documento) throws DocumentException {
        String text="";
        for (int i = 0; i < 2; i++) {
            text=" ";
            Paragraph text4 = new Paragraph(text);
            documento.add(text4);    
        } 
        
        text=TAGs[0][1].toUpperCase();

        int meitat = text.length()/2;
        int primer_espai = text.indexOf(" ", meitat);
        String titol1 = text.substring(0, primer_espai);
        String titol2 = text.substring(primer_espai+1,text.length());
        Paragraph text1 = new Paragraph(titol1,LletraNormalNegreta12);
        text1.setAlignment(Chunk.ALIGN_CENTER);
        text="";
        Paragraph text3 = new Paragraph(text,LletraNormal);
        Paragraph text2 = new Paragraph(titol2,LletraNormalNegreta12);
        text2.setAlignment(Chunk.ALIGN_CENTER);
        
        text=TAGs[1][1].toUpperCase();        
        
        PdfPTable tbl = new PdfPTable(3);
        tbl.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell(new Paragraph(text, LletraNormalNegreta12));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
 
        text=" ";
        cell = new PdfPCell(new Paragraph(text, LletraNormal));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        
        text="";
        text=TAGs[2][0].toUpperCase();
        text=text.concat(" "+TAGs[2][1]);
        
        cell = new PdfPCell(new Paragraph(text, LletraNormalNegreta12));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        
        try {
            documento.add(text1);
            documento.add(text3);
            documento.add(text2);
            documento.add(tbl);

        } catch (DocumentException ex) {
            Logger.getLogger(PdfHelloWorldAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    /**
     * Crea la part de dades de la Realització
     */
    private static void setRealitzacio(Document documento, int llengua) throws DocumentException {
        LineSeparator ls = new LineSeparator();
        ls.setLineWidth((float) 0.7);
        documento.add(new Chunk(ls));
        
        String text="";
        Paragraph text1 = new Paragraph(text,LletraNormal);
        documento.add(text1);
                
        Phrase myPhrase = new Phrase(TAGs[21][llengua]+"     ", LletraNormalNegreta12);
        documento.add(myPhrase);    
        text="";
        
        for (int i = 22; i < 24; i++) {
            text=text.concat(TAGs[i][llengua]);
            text=text.concat(" "+TAGs[i][1].toString());
            if(i==22){
                text=text.concat("                                        ");
            }

        }
        
        Phrase myPhrase2 = new Phrase(text, LletraNormal);    
        documento.add(myPhrase2);
        
        text=TAGs[24][llengua]+" "+TAGs[24][1];
        Paragraph text2 = new Paragraph(text,LletraNormal);
        text2.setAlignment(Chunk.ALIGN_LEFT);
        documento.add(text2);

        text="";
        Paragraph text3 = new Paragraph(text,LletraNormal);
        documento.add(text3);
        
        
    }

    /**
     * Crea la part de dades dels comentaris
     */
    private static void setComentaris(Document documento, int llengua) throws DocumentException {
        LineSeparator ls = new LineSeparator();
        ls.setLineWidth((float) 0.7);
        documento.add(new Chunk(ls));
        
        String text=TAGs[25][llengua];
        text=text.concat(" "+TAGs[25][1].toString().toUpperCase());
        Paragraph text1 = new Paragraph(text,LletraNormalNegreta12);
        text1.setAlignment(Chunk.ALIGN_CENTER);
        documento.add(text1);
        
        text=" ";
        Paragraph text3 = new Paragraph(text);
        documento.add(text3);
        
        text=TAGs[26][llengua];
        Paragraph text2 = new Paragraph(text,LletraNormal10);
        text2.setAlignment(Chunk.ALIGN_LEFT);
        documento.add(text2);
        
        text=TAGs[26][1];
        Paragraph text4 = new Paragraph(text,LletraNormal);
        text4.setAlignment(Chunk.ALIGN_LEFT);
        documento.add(text4);
        
        text=TAGs[27][1];
        Paragraph text5 = new Paragraph(text,LletraNormal);
        text5.setAlignment(Chunk.ALIGN_LEFT);
        documento.add(text5);
        
        text=TAGs[28][llengua];
        Paragraph text6 = new Paragraph(text,LletraNormal);
        text6.setAlignment(Chunk.ALIGN_LEFT);
        documento.add(text6);
        
        text=TAGs[28][1];
        Paragraph text7 = new Paragraph(text,LletraNormal);
        text7.setAlignment(Chunk.ALIGN_LEFT);
        documento.add(text7);
  
    }


    /**
     * Crea la part de dades Personals
     */
    private static void setDadesPersonals(Document documento, int llengua) throws DocumentException {
    
        LineSeparator ls = new LineSeparator();
        ls.setLineWidth((float) 0.7);
        documento.add(new Chunk(ls));
        
        String text="";
        Paragraph text1 = new Paragraph(text,LletraNormal);
        documento.add(text1);
        
        columna3(3,3,5,documento, llengua);
        columna2(3,6,7,documento, llengua);
        columna3(3,8,10,documento, llengua);
        columna3(3,11,13,documento, llengua);
        columna3(3,14,16,documento, llengua);
        columna3(3,17,19,documento, llengua);
        columna1(1,20,documento, llengua);
            
    }

    /**
     * Crea una fila de Dades personals amb 3 columnes
     */
    private static void columna3(int i, int ini, int fi, Document documento, int llengua) throws DocumentException {
        PdfPTable tbl = new PdfPTable(i);
        tbl.setWidthPercentage(100);
        
        String text="";
        text=TAGs[ini][llengua];
        text=text.concat(" "+TAGs[ini][1]);
        PdfPCell cell = new PdfPCell(new Paragraph(text, LletraNormal));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        
        text="";
        text=TAGs[ini+1][llengua];
        text=text.concat(" "+TAGs[ini+1][1]);
        cell = new PdfPCell(new Paragraph(text, LletraNormal));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        
        text="";
        text=TAGs[fi][llengua];
        text=text.concat(" "+TAGs[fi][1]);
        cell = new PdfPCell(new Paragraph(text, LletraNormal));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);  
        
        documento.add(tbl);
        
    }

    /**
     * Crea una fila de Dades personals amb 2 columnes
     */
    private static void columna2(int i, int ini, int fi, Document documento, int llengua) throws DocumentException {
        PdfPTable tbl = new PdfPTable(i);
        tbl.setWidthPercentage(100);
        
        String text="";
        text=TAGs[ini][llengua];
        text=text.concat(" "+TAGs[ini][1].toUpperCase());
        PdfPCell cell = new PdfPCell(new Paragraph(text, LletraNormal));
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
          
        text="";
        text=TAGs[fi][llengua];
        text=text.concat(" "+TAGs[fi][1]);
        cell = new PdfPCell(new Paragraph(text, LletraNormal));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        
        documento.add(tbl);   
        
    }

    /**
     * Crea una fila de Dades personals amb 1 column1
     */
    private static void columna1(int i, int ini, Document documento, int llengua) throws DocumentException {
        PdfPTable tbl = new PdfPTable(i);
        tbl.setWidthPercentage(100);
        
        String text="";
        text=TAGs[ini][llengua];
        text=text.concat(" "+TAGs[ini][1]);
        PdfPCell cell = new PdfPCell(new Paragraph(text, LletraNormal));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);    
        
        documento.add(tbl); 
        
    }

    /*
    private static void FilaFooter(int i, String frase1, String frase2, String frase3, Document documento) throws DocumentException {
        PdfPTable tbl = new PdfPTable(i);
        tbl.setWidthPercentage(100);
        String text="";
        text=frase1;
        PdfPCell cell = new PdfPCell(new Paragraph(text, Lletra6));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        
        text="";
        text=frase2;
        cell = new PdfPCell(new Paragraph(text, Lletra6));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        
        text="";
        text=frase3;
        cell = new PdfPCell(new Paragraph(text, Lletra6));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);        
        documento.add(tbl);  
                
    }
    */

    /**
     * Tria la llengua per fer l'informe. Es recull la llengua per consola
     */
    private static int triaLlenguaInforme() throws IOException {
        boolean menu = false;
        int resultat = 0;
        
        while(!menu){
        
            System.out.println("En quina llengua vols l'Informe ?");
            System.out.println("1. Català / Castellano");
            System.out.println("2. English");

            BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
            String ruta = lectura.readLine();
            switch(ruta){
                
                    case "1":
                        resultat = 0;
                        menu = true;
                        System.out.println("Has escollit/escogido: Català/Castellano");
                        break;
                        
                    case "2":
                        resultat = 2;
                        menu = true;
                        System.out.println("You have chosen: English");
                        break;
                        
                    default:
                        System.out.println("OPCIO INCORRECTA !");
                        break;
            }
            
        }
        return resultat;
    }

    private static void entradaDadesHardcoded() {
        TAGs[0][1]="CENTRE DE DIAGNÒSTIC BIOMÈDIC ANATOMIA PATOLÒGICA";
        TAGs[1][1]="ROCA TORRENT, JOSEP";
        TAGs[2][1]="351971";
        TAGs[3][1]="Masc.";
        TAGs[4][1]="23.11.1952";
        TAGs[5][1]="50 años";
        TAGs[6][1]="ROGER DE LLURIA, 77-79 4º2ª";
        TAGs[7][1]="08009";
        TAGs[8][1]="BARCELONA";
        TAGs[9][1]="6D";
        TAGs[10][1]="932850994";
        TAGs[11][1]="SERVEI CATALA DE LA SALUT";
        TAGs[12][1]="ROTO0521124007";
        TAGs[13][1]="08/0603754400";
        TAGs[14][1]="1000073367";
        TAGs[15][1]="HOSPIT.";
        TAGs[16][1]="25.07.2003";
        TAGs[17][1]="HEPATOLOGIA";
        TAGs[18][1]="G072 SALA G DE HEPATOLOGIA";
        TAGs[19][1]="";
        TAGs[20][1]="FUSTER OBREGON JOSE";
        TAGs[21][1]="";
        TAGs[22][1]="31.07.2003";
        TAGs[23][1]="15:20:00";
        TAGs[24][1]="AP020031013918";
        TAGs[25][1]="ANATOMIA PATOLOGICA";
        TAGs[26][1]="DESCRIPCION MACROSCOPICA (2003B013918) VESICULA BILIAR";
        TAGs[27][1]="Pieza de colecistectomía que mide 11,5 x 2 x 1 cm. La superficie externa es lisa, rosada y brillante. El grosor de la pared es de 0,2 cm. El contenido es biliar identificándose tres cálculos amarillo-parduscos el mayor de 2 x 1,3 cm. La superficie interna es verde y aterciopelada y presenta un marcado reticulado amarillento. Bloques: A.- margen de resección y ganglio pericístico 1/2; B.- secciones de la pared 1/2 IP.";
        TAGs[28][1]="VESICULA BILIAR (COLECISTECTOMIA): - COLECISTITIS CRONICA LITIASICA CON COLESTEROLOSIS.";
        TAGs[29][1]="";
    }

    /**
     * Registra les fonts que usarem en l'Informe.
     */
    private static void registraFontsText() {
        // Registra les dues fonts Trebuchet, la normal i la negreta
        FontFactory.register("c:/windows/fonts/trebuc.ttf", "Trebuchet");        
        FontFactory.register("c:/windows/fonts/trebucbd.ttf", "TrebuchetBOLD");
           
        // Creem els diferents tipus de lletres que utilitzem a l'informe i el seu tamany
        LletraNormalNegreta12 = FontFactory.getFont("TrebuchetBOLD", 12);
        LletraNormal = FontFactory.getFont("Trebuchet", 10);
        LletraNormal10 = FontFactory.getFont("TrebuchetBOLD", 10);
        Lletra6 = FontFactory.getFont("Trebuchet", 6);
    }

    private void procesaInforme(HttpServletRequest request, Document documento, int llengua, PdfWriter writer) throws IOException {
        // Creem la matriu de TAGs de l'Informe
        setGetTAGs();
        
        
        // Creem el arxiu on guardarem el pdf generat
        FileOutputStream ficheroPdf = null;
                
        try {
        	
        	/*
            if(llengua==0){
                ruta=ruta.concat("..\\CreateInforme\\Informe\\InformeCAT-SPA.pdf");
                ficheroPdf = new FileOutputStream(ruta);
            }
            else if(llengua==2){
                ruta=ruta.concat("..\\CreateInforme\\Informe\\InformeENG.pdf");
                ficheroPdf = new FileOutputStream(ruta);
            }
            else{
                ruta=ruta.concat("..\\CreateInforme\\Informe\\Informe.pdf");
                ficheroPdf = new FileOutputStream(ruta);                
            }
            */
            
            //PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);
            
            // Definim l'espai del logo amb el marge superior de la pàgina
            writer.setInitialLeading(15);
            
            writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
            
            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);
            
            // Obrim el document per escriure-hi les diferents parts
            documento.open();
            
            afegirImatgeClinic(request,documento);
            
            setCapcalera(documento);

            //System.out.println("LLENGUA : "+llengua);
            
            setDadesPersonals(documento,llengua);           
            
            setRealitzacio(documento,llengua);
            
            setComentaris(documento,llengua);
                       
            documento.newPage();
            
            documento.close();
            
            //System.out.println("PDF Generat a: "+ruta);
            
        } catch (DocumentException ex) {
            Logger.getLogger(PdfHelloWorldAction.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }	
	
	/** Classe per afegir footer de informació i pàgina. */
    static class HeaderFooter extends PdfPageEventHelper {
       
        
        public void onEndPage (PdfWriter writer, Document document) {
            Rectangle rect = writer.getBoxSize("art");

            String text1 = "El Hospital Clínic ha incorporado sus datos al Fichero de";
            String text2 = "HOSPITAL CLÍNIC DE BARCELONA";
            String text3 = "L'Hospital Clínic ha incorporat les seves dades al";
            
            String text4 = "Pacientes, para tratarlos con fines sanitarios.";
            String text5 = "Villarroel,170 08036-Barcelona (España)";
            String text6 = "Fitxer de Pacients, per a tractar-los amb finalitats";
            
            String text7 = "Puede ejercer sus derechos de acceso, rectificación,";
            String text8 = "Sabino de Arana ,1 08028-Barcelona (España)";
            String text9 = "sanitàries. Pot exercir els seus drets d'accés,";
            
            String text10 = "cancelación y oposición, así como obtener mas información";
            String text11 = "Tel. 93 227 54 00 Fax 93 227 54 54";
            String text12 = "rectificació, cancel-lació i oposició, i obtenir més";
            
            String text13 = "en la Unidad de Atención al Cliente.";
            String text14 = "http://www.hospitalclinic.org/";
            String text15 = "informació a la Unitat d'Atenció al Client.";
            
            try {
                PdfPTable table = FilaFooter( 3,  text1,  text2,  text3);
                float totalWidth = rect.getWidth();
                table.setTotalWidth(totalWidth);
                table.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin() + 32,writer.getDirectContent());

                table = FilaFooter( 3,  text4,  text5,  text6);
                table.setTotalWidth(totalWidth);
                table.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin() + 24,writer.getDirectContent());

                table = FilaFooter( 3,  text7,  text8,  text9);
                table.setTotalWidth(totalWidth);
                table.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin() + 16,writer.getDirectContent());
                
                table = FilaFooter( 3,  text10,  text11,  text12);
                table.setTotalWidth(totalWidth);
                table.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin() + 8,writer.getDirectContent());

                table = FilaFooter( 3,  text13,  text14,  text15);
                table.setTotalWidth(totalWidth);
                table.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin() ,writer.getDirectContent());
                
                String text="Vers.";
                Paragraph text0 = new Paragraph(text,LletraNormal);
                text0.setAlignment(Chunk.ALIGN_CENTER);
                
                ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format(text), LletraNormal),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() + 24, 0);

                text="Pag. "+pag_actual+" de "+pag_totals;
                ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format(text), LletraNormal),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() + 14, 0);
                
            } catch (DocumentException ex) {
                Logger.getLogger(PdfHelloWorldAction.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
        
        /**
        * Crea les 3 columnes per les condicions del peu de pàgina
        */
        private static PdfPTable FilaFooter(int i, String frase1, String frase2, String frase3) throws DocumentException {
            PdfPTable tbl = new PdfPTable(i);
            tbl.setWidthPercentage(100);
            String text="";
            text=frase1;
            PdfPCell cell = new PdfPCell(new Paragraph(text, Lletra6));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.disableBorderSide(Rectangle.BOX);
            tbl.addCell(cell);

            text="";
            text=frase2;
            cell = new PdfPCell(new Paragraph(text, Lletra6));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.disableBorderSide(Rectangle.BOX);
            tbl.addCell(cell);

            text="";
            text=frase3;
            cell = new PdfPCell(new Paragraph(text, Lletra6));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.disableBorderSide(Rectangle.BOX);
            tbl.addCell(cell);        
            return tbl;
                
        }
        
    }	
	
}