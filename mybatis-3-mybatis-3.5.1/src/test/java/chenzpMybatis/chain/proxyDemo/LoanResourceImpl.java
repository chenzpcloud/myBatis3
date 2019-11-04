package chenzpMybatis.chain.proxyDemo;

public class LoanResourceImpl implements  LoanResource {

    @Override
    public void loanApply() {
        System.out.println("贷款申请。。。。");
    }
}
