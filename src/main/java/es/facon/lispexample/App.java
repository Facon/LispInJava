package es.facon.lispexample;

import org.armedbear.lisp.Function;
import org.armedbear.lisp.Interpreter;
import org.armedbear.lisp.Packages;
import org.armedbear.lisp.Symbol;
import org.armedbear.lisp.Package;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Interpreter interpreter = Interpreter.createInstance();
			interpreter.eval("(load \"prueba.lisp\")");
			// the function is not in a separate package, thus the
			// correct package is CL-USER. Symbol names are
			// (usually) upper case.
			Package defaultPackage = Packages.findPackage("CL-USER");
			Symbol sym = defaultPackage.findAccessibleSymbol("HELLO");
			Function function = (Function) sym.getSymbolFunction();
			function.execute();
		} catch (Throwable t) {
			System.out.println("exception!");
			t.printStackTrace();
		}
	}
}
