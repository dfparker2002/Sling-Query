package com.cognifide.sling.query.function;

import java.util.Iterator;

import com.cognifide.sling.query.api.SearchStrategy;
import com.cognifide.sling.query.api.TreeProvider;
import com.cognifide.sling.query.api.function.ElementToIteratorFunction;
import com.cognifide.sling.query.iterator.tree.BfsTreeIterator;
import com.cognifide.sling.query.iterator.tree.DfsTreeIterator;

public class FindFunction<T> implements ElementToIteratorFunction<T> {

	private final String preFilteringSelector;

	private final TreeProvider<T> provider;

	private final SearchStrategy strategy;

	public FindFunction(String preFilteringSelector, SearchStrategy searchStrategy, TreeProvider<T> provider) {
		this.preFilteringSelector = preFilteringSelector;
		this.strategy = searchStrategy;
		this.provider = provider;
	}

	@Override
	public Iterator<T> apply(T resource) {
		switch (strategy) {
			case BFS:
				return new BfsTreeIterator<T>(resource, provider);
			case QUERY:
				return provider.query(preFilteringSelector, resource);
			case DFS:
			default:
				return new DfsTreeIterator<T>(resource, provider);
		}
	}
}