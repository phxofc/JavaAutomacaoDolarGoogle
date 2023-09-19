


import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;




public class Automacao {
    
   
    
    @Test
    public void pesquisaGoogle(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\phdfr\\OneDrive\\Documentos\\NetBeansProjects\\projetoGoogle\\src\\main\\java\\drive\\msedgedriver.exe");
        WebDriver navegar = new EdgeDriver(); 
        
        //escolher onde navegue
        
        navegar.get("https://www.google.com");
        navegar.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).click();
        navegar.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys("DOLAR HOJE", Keys.ENTER);
        
        WebElement valorDolarElement = navegar.findElement(By.xpath("//*[@id=\"knowledge-currency__updatable-data-column\"]/div[1]/div[2]/span[1]"));
        
        String valorDolar = valorDolarElement.getText();
        
        System.out.println("Valor dolar é: "+valorDolar);
        
        
        
        
        //criação planilha excell
        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("DolarHoje");
        
        //criando uma linha
        Row row= sheet.createRow(0);
        
         // Criar uma célula na linha e escrever o valor do dólar
        Cell cell = row.createCell(0);
        cell.setCellValue("Valor do dólar hoje");
        cell = row.createCell(1);
        cell.setCellValue(valorDolar);
        
        // Salvar a planilha em um arquivo
        try (FileOutputStream outputStream = new FileOutputStream("DolarHoje.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        navegar.quit();
        
    }
    
    
   
    
    
}
