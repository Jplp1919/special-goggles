package com.mycompany.wekaapipredict;

public class Pessoa {

    int id;
    int NumeroMorador;
    int Rendamedia2020IPCA;
    int Sexo;
    int Idade;
    int FrequentouEscola;
    int GrauEnsino;
    int ConcluiuSuperior;
    int GrauEnsinoMoradorMaisEstudou;
    int corRaca;
    int ProcurouServicoSaudeQuinzeDias;
    int TipoServicoSaude;
    int CumprindoIsolamento;
    int MotivoProcuraServico;
    int RotinaAtividades;
    int RotinaCasa;
    int ValorQualitativo;

    public Pessoa() {
    }

    public Pessoa(int id, int NumeroMorador, int Rendamedia2020IPCA, int Sexo, int Idade, int FrequentouEscola, int GrauEnsino, int ConcluiuSuperior, int GrauEnsinoMoradorMaisEstudou, int corRaca, int ProcurouServicoSaudeQuinzeDias, int TipoServicoSaude, int CumprindoIsolamento, int MotivoProcuraServico, int RotinaAtividades, int RotinaCasa, int ValorQualitativo) {
        this.id = id;
        this.NumeroMorador = NumeroMorador;
        this.Rendamedia2020IPCA = Rendamedia2020IPCA;
        this.Sexo = Sexo;
        this.Idade = Idade;
        this.FrequentouEscola = FrequentouEscola;
        this.GrauEnsino = GrauEnsino;
        this.ConcluiuSuperior = ConcluiuSuperior;
        this.GrauEnsinoMoradorMaisEstudou = GrauEnsinoMoradorMaisEstudou;
        this.corRaca = corRaca;
        this.ProcurouServicoSaudeQuinzeDias = ProcurouServicoSaudeQuinzeDias;
        this.TipoServicoSaude = TipoServicoSaude;
        this.CumprindoIsolamento = CumprindoIsolamento;
        this.MotivoProcuraServico = MotivoProcuraServico;
        this.RotinaAtividades = RotinaAtividades;
        this.RotinaCasa = RotinaCasa;
        this.ValorQualitativo = ValorQualitativo;
    }
    
    
    public Pessoa(Pessoa p) {
        this.id = p.getId();
        this.NumeroMorador = p.getNumeroMorador();
        this.Rendamedia2020IPCA = p.getRendamedia2020IPCA();
        this.Sexo = p.getSexo();
        this.Idade = p.getIdade();
        this.FrequentouEscola = p.getFrequentouEscola();
        this.GrauEnsino = p.getGrauEnsino();
        this.ConcluiuSuperior = p.getConcluiuSuperior();
        this.GrauEnsinoMoradorMaisEstudou = p.getGrauEnsinoMoradorMaisEstudou();
        this.corRaca = p.getCorRaca();
        this.ProcurouServicoSaudeQuinzeDias = p.getProcurouServicoSaudeQuinzeDias();
        this.TipoServicoSaude = p.getTipoServicoSaude();
        this.CumprindoIsolamento = p.getCumprindoIsolamento();
        this.MotivoProcuraServico = p.getMotivoProcuraServico();
        this.RotinaAtividades = p.getRotinaAtividades();
        this.RotinaCasa = p.getRotinaCasa();
        this.ValorQualitativo = p.getValorQualitativo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroMorador() {
        return NumeroMorador;
    }

    public void setNumeroMorador(int NumeroMorador) {
        this.NumeroMorador = NumeroMorador;
    }

    public int getRendamedia2020IPCA() {
        return Rendamedia2020IPCA;
    }

    public void setRendamedia2020IPCA(int Rendamedia2020IPCA) {
        this.Rendamedia2020IPCA = Rendamedia2020IPCA;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public int getFrequentouEscola() {
        return FrequentouEscola;
    }

    public void setFrequentouEscola(int FrequentouEscola) {
        this.FrequentouEscola = FrequentouEscola;
    }

    public int getGrauEnsino() {
        return GrauEnsino;
    }

    public void setGrauEnsino(int GrauEnsino) {
        this.GrauEnsino = GrauEnsino;
    }

    public int getConcluiuSuperior() {
        return ConcluiuSuperior;
    }

    public void setConcluiuSuperior(int ConcluiuSuperior) {
        this.ConcluiuSuperior = ConcluiuSuperior;
    }

    public int getGrauEnsinoMoradorMaisEstudou() {
        return GrauEnsinoMoradorMaisEstudou;
    }

    public void setGrauEnsinoMoradorMaisEstudou(int GrauEnsinoMoradorMaisEstudou) {
        this.GrauEnsinoMoradorMaisEstudou = GrauEnsinoMoradorMaisEstudou;
    }

    public int getCorRaca() {
        return corRaca;
    }

    public void setCorRaca(int corRaca) {
        this.corRaca = corRaca;
    }

    public int getProcurouServicoSaudeQuinzeDias() {
        return ProcurouServicoSaudeQuinzeDias;
    }

    public void setProcurouServicoSaudeQuinzeDias(int ProcurouServicoSaudeQuinzeDias) {
        this.ProcurouServicoSaudeQuinzeDias = ProcurouServicoSaudeQuinzeDias;
    }

    public int getTipoServicoSaude() {
        return TipoServicoSaude;
    }

    public void setTipoServicoSaude(int TipoServicoSaude) {
        this.TipoServicoSaude = TipoServicoSaude;
    }

    public int getCumprindoIsolamento() {
        return CumprindoIsolamento;
    }

    public void setCumprindoIsolamento(int CumprindoIsolamento) {
        this.CumprindoIsolamento = CumprindoIsolamento;
    }

    public int getMotivoProcuraServico() {
        return MotivoProcuraServico;
    }

    public void setMotivoProcuraServico(int MotivoProcuraServico) {
        this.MotivoProcuraServico = MotivoProcuraServico;
    }

    public int getRotinaAtividades() {
        return RotinaAtividades;
    }

    public void setRotinaAtividades(int RotinaAtividades) {
        this.RotinaAtividades = RotinaAtividades;
    }

    public int getRotinaCasa() {
        return RotinaCasa;
    }

    public void setRotinaCasa(int RotinaCasa) {
        this.RotinaCasa = RotinaCasa;
    }

    public int getValorQualitativo() {
        return ValorQualitativo;
    }

    public void setValorQualitativo(int ValorQualitativo) {
        this.ValorQualitativo = ValorQualitativo;
    }

}
