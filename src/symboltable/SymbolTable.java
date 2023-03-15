package symboltable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;
	public SymbolTable()  {
		table = new ArrayList<>();
		table.add(new HashMap<>());
	}

	public void set() {
		scope++;
		table.add(new HashMap<>());
	}
	
	public void reset() {
		table.remove(scope);
		scope--;
	}
	
	public boolean insert(Definition definition) {
		if (findInCurrentScope(definition.getName()) == null) {
			table.get(scope).put(definition.getName(), definition);
			definition.setScope(scope);
			return true;
		}
		return false;
	}
	
	public Definition find(String id) {
		int localScope = scope;
		while (localScope>=0) {
			if (table.get(localScope).containsKey(id)) {
				return table.get(localScope).get(id);
			}
			localScope--;
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}
}
