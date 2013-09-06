package br.com.view;


import br.com.model.negocio.Cliente;
import br.com.model.negocio.Compra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mayara_freita
 */
public class CompraTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_PRODUTO = 1;
    private static final int COL_CLIENTE = 2;
    private static final int COL_TOTAL_COMPRA = 3;
   
    private List<Compra> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Produto", "Cliente","Total Compra"};

    //Cria uma CompraTableModel sem nenhuma linha
    public CompraTableModel() {
        linhas = new ArrayList<Compra>();
    }

    //Cria uma CompraTableModel contendo a lista recebida por parâmetro.
    public CompraTableModel(List<Compra> compras) {
        this.linhas = new ArrayList<Compra>(compras);
    }

    public int getRowCount() {
        return linhas.size();
    }

    /*
     * Retorna a quantidade de colunas
     * 2 colunas: uma para id e a outra para nome.
     */
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Class getColumnClass(int columnIndex) {
        //Qual a classe das nossas colunas? A coluna 1 é inteira, as outras string.  
        if (columnIndex == COL_ID) {
            return Integer.class;
        } else if (columnIndex == COL_PRODUTO) {
            return String.class;
        } else if (columnIndex == COL_CLIENTE) {
            return Cliente.class;
        } else if (columnIndex == COL_TOTAL_COMPRA) {
            return String.class;
       
        }
        return Compra.class;
        

    }
     //return null;

   
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Retorna o valor da coluna e o valor da linha
    public Object getValueAt(int row, int column) {
        //pega o cliente da linha
        Compra c = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return c.getId();
        } else if (column == COL_PRODUTO) {
            return c.getProduto();
            } else if (column == COL_CLIENTE) {
            return c.getCliente();
        } else if (column == COL_TOTAL_COMPRA) {
            return c.getTotalCompra();
        }
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Compra c1 = linhas.get(row);
        if (column == COL_ID) {
            c1.setId((Integer) aValue);
        } else if (column == COL_PRODUTO) {
            c1.setProduto((String) aValue);
        } else if (column == COL_CLIENTE) {
            c1.setCliente((Cliente) aValue);
        } else if (column == COL_TOTAL_COMPRA) {
            c1.setTotalCompra((String) aValue);
        }
    }

    // Retorna a marca referente a linha especificada
    public Compra getCompra(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


    public void addCompra(Compra compra) {
        // Adiciona o registro.
        linhas.add(compra);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        

    }

    public void updateCompra(int indiceLinha, Compra compra) {
        linhas.set(indiceLinha, compra);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
       
    }

    //Remove o sócio da linha especificada.
    public void removeCompra(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }



        //avisa que a tabela foi alterada

        //fireTableDataChanged();
    
}
