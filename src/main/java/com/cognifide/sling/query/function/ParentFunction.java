package com.cognifide.sling.query.function;

import com.cognifide.sling.query.api.TreeProvider;
import com.cognifide.sling.query.api.function.ElementToElementFunction;

public class ParentFunction<T> implements ElementToElementFunction<T> {

	private final TreeProvider<T> provider;

	public ParentFunction(TreeProvider<T> provider) {
		this.provider = provider;
	}

	@Override
	public T apply(T resource) {
		return provider.getParent(resource);
	}

}
