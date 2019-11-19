class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {
  override def toString: String = {
    val referredCell = table.getCell(ix, iy);
    referredCell match {
      case None => "outOfRange"
      case some => some.get match {
        case ref: ReferenceCell => {
          if (table.getCell(ref.ix, ref.iy).contains(this)) "cyclic"
          else ref.toString
        }
        case other => other.toString
      }
    }
  }
}
