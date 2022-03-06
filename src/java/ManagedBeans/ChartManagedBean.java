/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Entity.TblDistrict;
import Entity.TblQuestionType;
import Entity.TblState;
import Entity.TblTaluka;
import Entity.TblVillage;
import Entity.TblWard;
import Entity.TblZone;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.polar.PolarAreaChartDataSet;
import org.primefaces.model.charts.polar.PolarAreaChartModel;

/**
 *
 * @author muzz
 */
@Named(value = "chartManagedBean")
@SessionScoped
public class ChartManagedBean implements Serializable {

    private PieChartModel pieModel;
    private BarChartModel barModel;
    private PolarAreaChartModel polarAreaModel;
    private LineChartModel lineModel;
    private DonutChartModel donutModel;
    
    EntityManager em;
    @EJB
    AdminSessionBeanLocal asb;
    Random random = new Random();
    HashMap<String, Integer> responses = new HashMap< String, Integer>();

    Collection<TblDistrict> district;
    Collection<TblTaluka> taluka;
    Collection<TblVillage> village;
    Collection<TblZone> zone;
    Collection<TblWard> ward;
    Collection<TblQuestionType> questype;
    Integer stateId, distId, talId, vilId, zoneId, wardId, quetypeId;

    /**
     * Creates a new instance of ChartManagedBean
     */
    @PostConstruct
    public void init() {
        System.out.println("Here in INIT");
        createPieModel();
        createBarModel();
        createPolarAreaModel();
        createLineModel();
        createDonutModel();
    }

    public DonutChartModel getDonutModel() {
        return donutModel;
    }

    public void setDonutModel(DonutChartModel donutModel) {
        this.donutModel = donutModel;
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public PolarAreaChartModel getPolarAreaModel() {
        return polarAreaModel;
    }

    public void setPolarAreaModel(PolarAreaChartModel polarAreaModel) {
        this.polarAreaModel = polarAreaModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Collection<TblDistrict> getDistrict() {
        return district;
    }

    public void setDistrict(Collection<TblDistrict> district) {
        this.district = district;
    }

    public Collection<TblTaluka> getTaluka() {
        return taluka;
    }

    public void setTaluka(Collection<TblTaluka> taluka) {
        this.taluka = taluka;
    }

    public Collection<TblVillage> getVillage() {
        return village;
    }

    public void setVillage(Collection<TblVillage> village) {
        this.village = village;
    }

    public Collection<TblZone> getZone() {
        return zone;
    }

    public void setZone(Collection<TblZone> zone) {
        this.zone = zone;
    }

    public Collection<TblWard> getWard() {
        return ward;
    }

    public void setWard(Collection<TblWard> ward) {
        this.ward = ward;
    }

    public Collection<TblQuestionType> getQuestype() {
        return questype;
    }

    public void setQuestype(Collection<TblQuestionType> questype) {
        this.questype = questype;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getDistId() {
        return distId;
    }

    public void setDistId(Integer distId) {
        this.distId = distId;
    }

    public Integer getTalId() {
        return talId;
    }

    public void setTalId(Integer talId) {
        this.talId = talId;
    }

    public Integer getVilId() {
        return vilId;
    }

    public void setVilId(Integer vilId) {
        this.vilId = vilId;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public Integer getQuetypeId() {
        return quetypeId;
    }

    public void setQuetypeId(Integer quetypeId) {
        this.quetypeId = quetypeId;
    }

    public HashMap<String, Integer> getResponses() {
        return responses;
    }

    public void setResponses(HashMap<String, Integer> responses) {
        this.responses = responses;
    }

    public PieChartModel getPieModel() {
        
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public ChartManagedBean() {
    }

    public Collection<TblState> findAllState() {
        return asb.findAllState();
    }

    public Collection<TblDistrict> findAllDistrict() {
        return asb.findStateByDistrictId(stateId);
    }

    public Collection<TblTaluka> findAllTaluka() {
        return asb.findTalukaByDistrictId(distId);
    }

    public Collection<TblVillage> findAllVillage() {
        return asb.findVillageByTalukaId(talId);
    }

    public Collection<TblZone> findAllZone() {
        return asb.findZoneByVillageId(vilId);
    }

    public Collection<TblWard> findAllWard() {
        return asb.findwardByZoneId(zoneId);
    }

    public void dropState(AjaxBehaviorEvent enevt) {
        district = asb.findStateByDistrictId(stateId);
        responses = asb.getCountsByIssueState(quetypeId, stateId);
        createPieModel();
        createBarModel();
        createPolarAreaModel();
        createLineModel();
        createDonutModel();
        System.out.println("State ID " + stateId);
    }

    public void dropdistrict(AjaxBehaviorEvent event) {
        taluka = asb.findTalukaByDistrictId(distId);
        responses = asb.getCountsByIssueDistrict(quetypeId, distId);
        createPieModel();
        createBarModel();
        createPolarAreaModel();
        createLineModel();
        createDonutModel();
        System.out.println("District ID " + distId);
    }

    public void droptaluka(AjaxBehaviorEvent event) {
        village = asb.findVillageByTalukaId(talId);
        responses = asb.getCountsByIssueTaluka(quetypeId, talId);
        createPieModel();
        createBarModel();
        createPolarAreaModel();
        createLineModel();
        createDonutModel();
        System.out.println("Taluka ID " + talId);
    }

    public void dropVillage(AjaxBehaviorEvent event) {
        zone = asb.findZoneByVillageId(vilId);
        responses = asb.getCountsByIssueVillage(quetypeId, vilId);
        createPieModel();
        createBarModel();
        createPolarAreaModel();
        createLineModel();
        createDonutModel();
        System.out.println("Village ID " + vilId);
    }

    public void dropZone(AjaxBehaviorEvent event) {
        System.out.println("Zone Id :" + zoneId);
        responses = asb.getCountsByIssueZone(quetypeId, zoneId);
        createPieModel();
        createBarModel();
        createPolarAreaModel();
        createLineModel();
        createDonutModel();
    }

    public Collection<TblQuestionType> allQuesType() {
        return this.asb.findAllQuestionType();
    }

    public void allquestionType(AjaxBehaviorEvent event) {
//        this.responses = asb.getCountsByIssue(this.quetypeId);
        responses = asb.getCountsByIssue(this.quetypeId);
        System.out.println("Question Type Id :" + this.quetypeId);
        createPieModel();
        createBarModel();
        createPolarAreaModel();
        createLineModel();
        createDonutModel();
    }

    private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
        //Get By Issue Type : Displays States wise reponses
//        if(quetypeId==null){
//            quetypeId=2;
//        }
//        responses = asb.getCountsByIssue(this.quetypeId);
        //Get By Issue Type And State wise : Displays District wise reponses
        //responses = asb.getCountsByIssueState(2,4);
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();

        for (HashMap.Entry r : responses.entrySet()) {
            values.add((Integer) r.getValue());
        }
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            bgColors.add("rgb(" + random.nextInt(256) + ", " + random.nextInt(256) + ", " + random.nextInt(256) + ")");
        }
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            labels.add(r.getKey().toString());
        }
        data.setLabels(labels);

        pieModel.setData(data);
    }

    public void createBarModel() {
        System.out.println("I'm in Bar CHart");
        barModel = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("");

        List<Number> values = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            values.add((Integer) r.getValue());
        }
        barDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            bgColor.add("rgb(" + random.nextInt(256) + ", " + random.nextInt(256) + ",0.2)");
        }
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            bgColor.add("rgb(" + random.nextInt(256) + ", " + random.nextInt(256) + ", " + random.nextInt(256) + ")");
        }
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);

        data.addChartDataSet(barDataSet);

        List<String> labels = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            labels.add(r.getKey().toString());
        }
        data.setLabels(labels);
        barModel.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        barModel.setOptions(options);
    }

    private void createPolarAreaModel() {
        polarAreaModel = new PolarAreaChartModel();
        ChartData data = new ChartData();

        PolarAreaChartDataSet dataSet = new PolarAreaChartDataSet();
        List<Number> values = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            values.add((Integer) r.getValue());
        }
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            bgColors.add("rgb(" + random.nextInt(256) + ", " + random.nextInt(256) + ",0.2)");
        }
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            labels.add(r.getKey().toString());
        }
        data.setLabels(labels);

        polarAreaModel.setData(data);
    }
    
    public void createLineModel() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();

        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            values.add((Integer) r.getValue());
        }
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("My First Dataset");
        dataSet.setBorderColor("rgb(75, 192, 192)");
        dataSet.setTension(0.1);
        data.addChartDataSet(dataSet);

        List<String> labels = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            labels.add(r.getKey().toString());
        }
        data.setLabels(labels);

        //Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart");
        options.setTitle(title);

        lineModel.setOptions(options);
        lineModel.setData(data);
    }
    
    public void createDonutModel() {
        donutModel = new DonutChartModel();
        ChartData data = new ChartData();

        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            values.add((Integer) r.getValue());
        }
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            bgColors.add("rgb(" + random.nextInt(256) + ", " + random.nextInt(256) + ",0.2)");
        }
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        for (HashMap.Entry r : responses.entrySet()) {
            labels.add(r.getKey().toString());
        }
        data.setLabels(labels);

        donutModel.setData(data);
    }

}
