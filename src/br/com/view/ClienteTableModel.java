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
public class ClienteTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_RG = 2;
    private static final int COL_CPF = 3;
    private static final int COL_TELEFONE = 4;
      private static final int COL_ENDERECO = 5;
    private List<Cliente> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Nome", "Rg", "Cpf", "Telefone", "Endereço"};

    //Cria uma ClienteTableModel sem nenhuma linha
    public ClienteTableModel() {
        linhas = new ArrayList<Cliente>();
    }

    //Cria uma ClienteTableModel contendo a lista recebida por parâmetro.
    public ClienteTableModel(List<Cliente> clientes) {
        this.linhas = new ArrayList<Cliente>(clientes);
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
        } else if (columnIndex == COL_NOME) {
            return String.class;
        } else if (columnIndex == COL_RG) {
            return String.class;
        } else if (columnIndex == COL_CPF) {
            return String.class;
        } else if (columnIndex == COL_TELEFONE) {
             return String.class;
        }else if (columnIndex == COL_ENDERECO){
             return String.class;
        }
        return Cliente.class;
        

    }
     //return null;

   
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Retorna o valor da coluna e o valor da linha
    public Object getValueAt(int row, int column) {
        //pega o cliente da linha
        Cliente c = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return c.getId();
        } else if (column == COL_NOME) {
            return c.getNome();
        } else if (column == COL_RG) {
            return c.getRg();
        } else if (column == COL_CPF) {
            return c.getCpf();
        } else if (column == COL_TELEFONE) {
            return c.getTelefone();
        }else if (column == COL_ENDERECO) {
            return c.getEndereco();
        }
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Cliente c1 = linhas.get(row);
        if (column == COL_ID) {
            c1.setId((Integer) aValue);
        } else if (column == COL_NOME) {
            c1.setNome((String) aValue);
        } else if (column == COL_RG) {
            c1.setRg((String) aValue);
        } else if (column == COL_CPF) {
            c1.setCpf((String) aValue);
        } else if (column == COL_TELEFONE) {
            c1.setTelefone((String) aValue);
        } else if (column == COL_ENDERECO) {
            c1.setEndereco((String) aValue);
        }
    }

    // Retorna a marca referente a linha especificada
    public Cliente getCliente(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


    public void addCliente(Cliente cliente) {
        // Adiciona o registro.
        linhas.add(cliente);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        

    }

    public void updateCliente(int indiceLinha, Cliente cliente) {
        linhas.set(indiceLinha, cliente);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
       
    }

    //Remove o sócio da linha especificada.
    public void removeCliente(int indiceLinha) {
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
