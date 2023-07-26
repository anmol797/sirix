package io.sirix.query.compiler.translator;

import io.sirix.api.Axis;
import org.brackit.xquery.jdm.Item;
import org.brackit.xquery.jdm.Iter;
import org.brackit.xquery.sequence.BaseIter;
import org.brackit.xquery.sequence.LazySequence;
import io.sirix.query.stream.json.SirixJsonStream;

class SirixJsonLazySequence extends LazySequence {

  private final SirixJsonStream stream;

  SirixJsonLazySequence(final SirixJsonStream stream) {
    this.stream = stream;
  }

  Axis getAxis() {
    return stream.getAxis();
  }

  @Override
  public Iter iterate() {
    return new BaseIter() {
      @Override
      public Item next() {
        return stream.next();
      }

      @Override
      public void close() {
      }
    };
  }
}