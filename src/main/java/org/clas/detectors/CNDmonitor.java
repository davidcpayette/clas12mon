package org.clas.detectors;

import org.clas.viewer.DetectorMonitor;
import org.jlab.groot.data.H1F;
import org.jlab.groot.data.H2F;
import org.jlab.groot.group.DataGroup;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;


public class CNDmonitor  extends DetectorMonitor {        
    
    public CNDmonitor(String name) {
        super(name);
        
        this.setDetectorTabNames("ADC Occupancies", "TDC Occupancies");
        this.init(false);
    }

    @Override
    public void createHistos() {
        // initialize canvas and create histograms
        this.setNumberOfEvents(0);
        
        H1F summary = new H1F("summary","summary",72,0.5,72.5);
        summary.setTitleX(" PMT (all layers combined)");
        summary.setTitleY("CND hits");
        summary.setTitle("CND");
        summary.setFillColor(38);
        DataGroup sum = new DataGroup(1,1);
        sum.addDataSet(summary, 0);
        this.setDetectorSummary(sum);
        
        H2F occADCL = new H2F("occADC_left", "Occupancy ADC left vs layer", 24 , 1, 25, 3, 1, 4);
        occADCL.setTitleX("PMT left");
        occADCL.setTitleY("layer");
        //occADCL.setTitle("Left PMTs vs layer");
            
        H2F occADCR = new H2F("occADC_right", "Occupancy ADC right vs layer", 24, 1, 25, 3, 1, 4);
        occADCR.setTitleX("PMT right");
        occADCR.setTitleY("layer");
        //occADCR.setTitle("Right PMTs vs layer");
        
        H2F adcL = new H2F("adcL", "adcL", 50, 0, 5000, 72, 0.5, 72.5);
        adcL.setTitleX("ADC left - amplitude");
        adcL.setTitleY("PMT left (all layers combined)");
        //adcL.setTitle("Left ADC amplitude distribution");
        
        H2F adcR = new H2F("adcR", "adcR", 50, 0, 5000, 72, 0.5, 72.5);
        adcR.setTitleX("ADC right - amplitude");
        adcR.setTitleY("PMT right (all layers combined)"); 
        //adcR.setTitle("Right ADC amplitude distribution");
            
        H2F occTDCL = new H2F("occTDC_left", "Occupancy TDC left vs layer", 24, 1, 25, 3, 0.5, 3.5);
        occTDCL.setTitleX("PMT left");
        occTDCL.setTitleY("layer");
        //occTDCL.setTitle("Left PMTs vs layer");
            
        H2F occTDCR = new H2F("occTDC_right", "Occupancy TDC right vs layer", 24, 1, 25, 3, 0.5, 3.5);
        occTDCR.setTitleX("PMT right");
        occTDCR.setTitleY("layer");
        //occTDCR.setTitle("Right PMTs vs layer");
         
        H2F tdcL = new H2F("tdcL", "tdcL", 50, 0, 17000, 72, 0.5, 72.5);
        tdcL.setTitleX("TDC left - amplitude");
        tdcL.setTitleY("PMT left (all layers combined)");
        //tdcL.setTitle("Left TDC amplitude distribution");
        
        H2F tdcR = new H2F("tdcR", "tdcR", 50, 0, 17000, 72, 0.5, 72.5);
        tdcR.setTitleX("TDC right - amplitude");
        tdcR.setTitleY("PMT right (all layers combined)");
        //tdcR.setTitle("Right TDC amplitude distribution");
        
        DataGroup dg = new DataGroup(2,4);
        dg.addDataSet(occADCL, 0);
        dg.addDataSet(occADCR, 1);
        dg.addDataSet(adcL, 2);
        dg.addDataSet(adcR, 3);
        dg.addDataSet(occTDCL, 4);
        dg.addDataSet(occTDCR, 5);
        dg.addDataSet(tdcL, 6);
        dg.addDataSet(tdcR, 7);
        this.getDataGroup().add(dg, 0, 0, 0);
      
    }
        
    @Override
    public void plotHistos() {        
        // plotting histos
        this.getDetectorCanvas().getCanvas("ADC Occupancies").divide(2,2);
        this.getDetectorCanvas().getCanvas("ADC Occupancies").setGridX(false);
        this.getDetectorCanvas().getCanvas("ADC Occupancies").setGridY(false);
        this.getDetectorCanvas().getCanvas("TDC Occupancies").divide(2,2);
        this.getDetectorCanvas().getCanvas("TDC Occupancies").setGridX(false);
        this.getDetectorCanvas().getCanvas("TDC Occupancies").setGridY(false);        
        
        this.getDetectorCanvas().getCanvas("ADC Occupancies").cd(0);
        this.getDetectorCanvas().getCanvas("ADC Occupancies").getPad(0).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("ADC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("occADC_left"));
        this.getDetectorCanvas().getCanvas("ADC Occupancies").cd(1);
        this.getDetectorCanvas().getCanvas("ADC Occupancies").getPad(1).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("ADC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("occADC_right"));
        this.getDetectorCanvas().getCanvas("ADC Occupancies").cd(2);
        this.getDetectorCanvas().getCanvas("ADC Occupancies").getPad(2).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("ADC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("adcL"));
        this.getDetectorCanvas().getCanvas("ADC Occupancies").cd(3);
        this.getDetectorCanvas().getCanvas("ADC Occupancies").getPad(3).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("ADC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("adcR"));
        this.getDetectorCanvas().getCanvas("ADC Occupancies").update();
        this.getDetectorCanvas().getCanvas("TDC Occupancies").cd(0);
        this.getDetectorCanvas().getCanvas("TDC Occupancies").getPad(0).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("TDC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("occTDC_left"));
        this.getDetectorCanvas().getCanvas("TDC Occupancies").cd(1);
        this.getDetectorCanvas().getCanvas("TDC Occupancies").getPad(1).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("TDC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("occTDC_right"));
        this.getDetectorCanvas().getCanvas("TDC Occupancies").cd(2);
        this.getDetectorCanvas().getCanvas("TDC Occupancies").getPad(2).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("TDC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("tdcL"));
        this.getDetectorCanvas().getCanvas("TDC Occupancies").cd(3);
        this.getDetectorCanvas().getCanvas("TDC Occupancies").getPad(3).getAxisZ().setLog(getLogZ());
        this.getDetectorCanvas().getCanvas("TDC Occupancies").draw(this.getDataGroup().getItem(0,0,0).getH2F("tdcR"));
        this.getDetectorCanvas().getCanvas("TDC Occupancies").update();
        
    }

    @Override
    public void processEvent(DataEvent event) {
        
        if (this.getNumberOfEvents() >= super.eventResetTime_current[2] && super.eventResetTime_current[2] > 0){
            resetEventListener();
        }
        
        if(   !isGoodTrigger1() && !isGoodTrigger2() && !isGoodTrigger3() && !isGoodTrigger4() 
           && !isGoodTrigger5() && !isGoodTrigger6() && !isGoodTrigger7() && !isGoodTrigger8()
           && !isGoodTrigger9() && !isGoodTrigger10() && !isGoodTrigger11() && !isGoodTrigger12()  
           && !isGoodTrigger13() && !isGoodTrigger14() && !isGoodTrigger15() && !isGoodTrigger16()  
           && !isGoodTrigger17() && !isGoodTrigger18() && !isGoodTrigger19() && !isGoodTrigger20()
           && !isGoodTrigger21() && !isGoodTrigger22() && !isGoodTrigger23() && !isGoodTrigger24()
           && !isGoodTrigger25() && !isGoodTrigger26() && !isGoodTrigger27() && !isGoodTrigger28()  
           && !isGoodTrigger29() && !isGoodTrigger30() && !isGoodTrigger31() && !isGoodTrigger32()) return;
             
        if (!isGoodCNDTrigger()) return;
        
        // process event info and save into data group
        if(event.hasBank("CND::adc")==true){
	    DataBank bank = event.getBank("CND::adc");
	    int rows = bank.rows();
	    for(int loop = 0; loop < rows; loop++){
                int sector  = bank.getByte("sector", loop);
                int layer   = bank.getByte("layer", loop);
                int comp    = bank.getShort("component", loop);
                int order   = bank.getByte("order", loop);
                int adc     = bank.getInt("ADC", loop);
                float time  = bank.getFloat("time", loop);
//                System.out.println("ROW " + loop + " SECTOR = " + sector + " LAYER = " + layer + " COMPONENT = " + comp + " ORDER + " + order +
//                      " ADC = " + adc + " TIME = " + time); 
                if(adc>0) {
                    if(order==0) {
                        this.getDataGroup().getItem(0,0,0).getH2F("occADC_left").fill(sector,layer);
                        this.getDataGroup().getItem(0,0,0).getH2F("adcL").fill(adc*1.0,((sector-1)*3 + layer)*1.0);
                    }
                    else if(order==1) {
                        this.getDataGroup().getItem(0,0,0).getH2F("occADC_right").fill(sector,layer);
                        this.getDataGroup().getItem(0,0,0).getH2F("adcR").fill(adc*1.0,((sector-1)*3 + layer)*1.0);
                    }
                   
                    this.getDetectorSummary().getH1F("summary").fill((sector-1)*3+layer);
                }
                
	    }
    	}
        if(event.hasBank("CND::tdc")==true){
            DataBank  bank = event.getBank("CND::tdc");
            int rows = bank.rows();
            for(int i = 0; i < rows; i++){
                int    sector = bank.getByte("sector",i);
                int     layer = bank.getByte("layer",i);
                int      comp = bank.getShort("component",i);
                int       tdc = bank.getInt("TDC",i);
                int     order = bank.getByte("order",i); // order specifies left-right for ADC
//                           System.out.println("ROW " + i + " SECTOR = " + sector
//                                 + " LAYER = " + layer + " PADDLE = "
//                                 + comp + " TDC = " + tdc);    
                if(tdc>0) {
                    if(order==2) {
                        this.getDataGroup().getItem(0,0,0).getH2F("occTDC_left").fill(sector,layer);
                        this.getDataGroup().getItem(0,0,0).getH2F("tdcL").fill(tdc*1.0,((sector-1)*3 + layer)*1.0);
                    }
                    else if(order==3) {
                        this.getDataGroup().getItem(0,0,0).getH2F("occTDC_right").fill(sector, layer);
                        this.getDataGroup().getItem(0,0,0).getH2F("tdcR").fill(tdc*1.0,((sector-1)*3 + layer)*1.0);
                    }
                }
            }
        }        
    }

    @Override
    public void timerUpdate() {

    }


}
