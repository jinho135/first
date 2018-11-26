package Swing.model;

import java.awt.Panel;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class KcalChart extends Panel {
	KcalDBA dba = new KcalDBA();
	ArrayList<KcalChartBean> arr6;
 
	public KcalChart(ArrayList<KcalChartBean> arr6) {
		this.arr6 = arr6;
		JFreeChart lineChart = ChartFactory.createLineChart("Remaining kcal", "Date", "kcal", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(720, 310));
		add(chartPanel);
		setVisible(true);
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < arr6.size(); i++) {
			dataset.addValue(arr6.get(i).getKcalfianl(), "kcal", arr6.get(i).getKcaldate());
		}
		return dataset;
	}

}