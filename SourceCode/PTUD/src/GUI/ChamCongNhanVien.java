package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ChamCongNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public ChamCongNhanVien() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BẢNG CHẤM CÔNG NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground((new Color(0, 27, 72)));
		
		lblNewLabel.setBounds(300, 5, 850, 90);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1430, 500);
		add(scrollPane);
		
		table_1 = new JTable() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return column >= 3;
            }
        };
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setEditingRow(0);
        table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        scrollPane.setViewportView(table_1);

		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Ng\u00E0y ch\u1EA5m c\u00F4ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Tr\u1EA1ng Th\u00E1i", "Ca L\u00E0m", "S\u1ED1 gi\u1EDD t\u0103ng ca"
			
		}));
		String[] gioTangCaLuaChon = {"0", "1", "2", "3", "4"};
        JComboBox<String> gioTangCaComboBox = new JComboBox<>(gioTangCaLuaChon);
        DefaultCellEditor editorGioTangCa = new DefaultCellEditor(gioTangCaComboBox);
        TableColumn gioTangCaColumn = table_1.getColumnModel().getColumn(5);
        gioTangCaColumn.setCellEditor(editorGioTangCa);
        gioTangCaComboBox.setSelectedItem("0");
        
        String[] caLamLuaChon = {"Ca sáng", "Ca chiều"};
        JComboBox<String> caLamComboBox = new JComboBox<>(caLamLuaChon);
        DefaultCellEditor editorCaLam = new DefaultCellEditor(caLamComboBox);
        table_1.getColumnModel().getColumn(4).setCellEditor(editorCaLam);
        gioTangCaComboBox.setSelectedItem("Ca sáng");
        
        String[] trangThaiLuaChon = {
                "Chưa ghi nhận công",
                "Làm nguyên ca",
                "Làm nửa ca",
                "Nghỉ có phép",
                "Nghỉ không phép"
            };
        JComboBox<String> trangThaiComboBox = new JComboBox<>(trangThaiLuaChon);
        DefaultCellEditor editorTrangThai = new DefaultCellEditor(trangThaiComboBox);
        table_1.getColumnModel().getColumn(3).setCellEditor(editorTrangThai);
        gioTangCaComboBox.setSelectedItem("Chưa ghi nhận công");

        DefaultTableModel model = (DefaultTableModel) table_1.getModel();

		for (int row = 0; row < model.getRowCount(); row++) {
		     model.setValueAt("Chưa ghi nhận công", row, 3); 
		     model.setValueAt("Ca sáng", row, 4); 
		     model.setValueAt("0", row, 5);     
		}
        
		JTableHeader tb= table_1.getTableHeader();
		tb.setBackground(new Color(151, 201, 219));
		tb.setFont(new Font("Tahoma", Font.BOLD, 16));
		 int rowHeight = 30;
        int rowMargin = 10;
        table_1.setRowHeight(rowHeight);
        table_1.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
		
		JButton btnNewButton = new JButton("Chấm Công");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(2, 104, 156));
		btnNewButton.setBounds(525, 630, 170, 50);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(120, 186, 219));
		btnNewButton_1.setBounds(755, 630, 170, 50);
		add(btnNewButton_1);

	}
}
