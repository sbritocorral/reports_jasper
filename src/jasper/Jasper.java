/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import jasper.conecciones.conexion;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.codec.StringDecoder;
import net.sf.jasperreports.components.barbecue.BarbecueFillComponent;
import org.apache.batik.bridge.Bridge;
import net.sourceforge.barbecue.Barcode;
import net.sf.jasperreports.functions.FunctionsBundle;
import org.joda.time.DateTime;

public class Jasper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;
        Connection conn = null;
        // Compile jrxml file.
        try {
            jasperReport = JasperCompileManager.compileReport("C:\\Users\\Jorge\\factura_electronica.jrxml");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("clave_acceso", "1306201801010592198500110010010000003622963371716");

        try {
            conn = conexion.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parameters, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                    "C:\\reportes\\1306201801010592198500110010010000003622963371716.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            jasperViewer = new JasperViewer(jasperPrint);
            jasperViewer.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Export to PDF.

        System.out.println("Done!");

    }
}
