package com.aya.data.repository;

import com.aya.data.api.MovieApis;
import com.aya.data.database.MovieDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class MovieRepositoryImpl_Factory implements Factory<MovieRepositoryImpl> {
  private final Provider<MovieApis> apiProvider;

  private final Provider<MovieDao> daoProvider;

  public MovieRepositoryImpl_Factory(Provider<MovieApis> apiProvider,
      Provider<MovieDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public MovieRepositoryImpl get() {
    return newInstance(apiProvider.get(), daoProvider.get());
  }

  public static MovieRepositoryImpl_Factory create(Provider<MovieApis> apiProvider,
      Provider<MovieDao> daoProvider) {
    return new MovieRepositoryImpl_Factory(apiProvider, daoProvider);
  }

  public static MovieRepositoryImpl newInstance(MovieApis api, MovieDao dao) {
    return new MovieRepositoryImpl(api, dao);
  }
}
