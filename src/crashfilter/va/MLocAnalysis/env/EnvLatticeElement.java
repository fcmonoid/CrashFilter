package crashfilter.va.MLocAnalysis.env;

import java.util.Set;

import com.google.security.zynamics.binnavi.API.gui.LogConsole;
import com.google.security.zynamics.binnavi.API.reil.mono.ILatticeElement;
import com.google.security.zynamics.binnavi.API.reil.mono.InstructionGraphNode;

import crashfilter.va.regs.IRegister;

public class EnvLatticeElement implements ILatticeElement<EnvLatticeElement>{
	private InstructionGraphNode inst;
	private Env env;

	
	
	public EnvLatticeElement()
	{
		env = new Env();
	}
	
	public void setEnv(Env env)
	{
		this.env = env;
	}
	public void setInst(InstructionGraphNode inst)
	{
		this.inst = inst;
	}
	public InstructionGraphNode getInst()
	{
		return inst;
	}
	public Env getEnv()
	{
		return this.env;
	}
	
	public void combine( EnvLatticeElement envLatticeElement)
	{		
		this.inst = envLatticeElement.inst;
		
		Env combinedEnv = env.combine(envLatticeElement.env);
		this.env = combinedEnv;
		
	}
	
	@Override
	public boolean equals(EnvLatticeElement obj) {
		Boolean bool;
		Env e1 = this.env;
		Env e2 = obj.env;
		
		bool = e1.equals(e2);
		return bool;
	}

	@Override
	public boolean lessThan(EnvLatticeElement EnvElement) {
		return this.env.lessthan(EnvElement.env);
		//return false;
	}
	
	
}